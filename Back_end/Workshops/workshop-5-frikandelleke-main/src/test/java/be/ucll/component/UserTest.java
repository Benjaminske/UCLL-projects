package be.ucll.component;

import be.ucll.model.User;
import be.ucll.repository.DbInitializer;
import be.ucll.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Sql("classpath:schema.sql")
public class UserTest {

    private WebTestClient webTestClient;
    private UserRepository userRepository;
    private DbInitializer dbInitializer;

    @Autowired
    public UserTest(WebTestClient webTestClient, UserRepository userRepository, DbInitializer dbInitializer) {
        this.webTestClient = webTestClient;
        this.userRepository = userRepository;
        this.dbInitializer = dbInitializer;
    }

    @BeforeEach
    public void setup() {
        dbInitializer.initialize();
    }

    @Test
    public void givenUsers_whenGetUsers_thenUsersAreReturned() {
        webTestClient
                .get()
                .uri("/users")
                .exchange().expectStatus().isOk()
                .expectBody()
                .json("""
                  [
                    {"name":"John Doe","age":25,"email":"john.doe@ucll.be","password":"john1234"},
                    {"name":"Jane Toe","age":30,"email":"jane.toe@ucll.be","password":"jane1234"},
                    {"name":"Birgit Doe","age":18,"email":"birgit.doe@ucll.be","password":"birgit1234"},
                    {"name":"Jack Doe","age":5,"email":"jack.doe@ucll.be","password":"jack1234"},
                    {"name":"Sarah Doe","age":4,"email":"sarah.doe@ucll.be","password":"sarah1234"}
                  ]
                  """);
    }

    @Test
    public void givenUserWithLoans_whenGettingLoansOfUser_thenLoansAreReturned() {
        LocalDate startDate = LocalDate.now().minusDays(22);
        LocalDate endDate = startDate.plusWeeks(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        webTestClient
                .get()
                .uri("/users/john.doe@ucll.be/loans?onlyActive=false")
                .exchange().expectStatus().isOk()
                .expectBody()
                .json(String.format("""
                        [
                         {
                             "user": {
                                 "name": "John Doe",
                                 "age": 25,
                                 "email": "john.doe@ucll.be",
                                 "password": "john1234"
                             },
                             "publications": [
                                 {
                                     "title": "The Catcher in the Rye",
                                     "author": "J.D. Salinger",
                                     "isbn": "0123456",
                                     "pubYear": 1951,
                                     "availableCopies": 4
                                 }
                             ],
                             "startDate": "%s",
                             "endDate": "%s"
                         },
                         {
                             "user": {
                                 "name": "John Doe",
                                 "age": 25,
                                 "email": "john.doe@ucll.be",
                                 "password": "john1234"
                             },
                             "publications": [
                                 {
                                     "title": "1984",
                                     "author": "George Orwell",
                                     "isbn": "012587",
                                     "pubYear": 1949,
                                     "availableCopies": 1
                                 }
                             ],
                             "startDate": "%s",
                             "endDate": "%s"
                         }
                     ]
                        """, formatter.format(startDate), formatter.format(endDate), formatter.format(startDate), formatter.format(endDate)));
    }

    @Test
    public void givenValidUserInformation_whenCreatingAUser_thenAUserIsCreated() {
        webTestClient
                .post()
                .uri("/users")
                .header("Content-Type", "application/json")
                .bodyValue("""
                        {
                          "name": "Simon",
                          "age": "14",
                          "email": "simon@synka.com",
                          "password": "mtholly1234"
                        }
                        """)
                .exchange().expectStatus().is2xxSuccessful()
                .expectBody()
                .json("""
                    {"name":"Simon","age":14,"email":"simon@synka.com","password":"mtholly1234"}
                  """);
    }

    @Test
    public void givenValidUserWithProfile_whenCreatingUser_thenUserAndProfileAreCreated() {
        webTestClient
                .post()
                .uri("/users")
                .header("Content-Type", "application/json")
                .bodyValue("""
                        {
                          "name": "Alice Doe",
                          "age": "22",
                          "email": "alice.doe@ucll.be",
                          "password": "alice1234",
                          "profile": {
                            "role": "Engineer",
                            "location": "Brussels",
                            "interests": "Cycling, Reading"
                          }
                        }
                        """)
                .exchange().expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Alice Doe")
                .jsonPath("$.profile.role").isEqualTo("Engineer")
                .jsonPath("$.profile.location").isEqualTo("Brussels");
    }

    @Test
    public void givenExistingUser_whenUpdatingUserWithNewInformation_thenInformationIsUpdated() {
        webTestClient
                .put()
                .uri("/users/john.doe@ucll.be")
                .header("Content-Type", "application/json")
                .bodyValue("""
                        {
                          "name": "Timmy Doe",
                          "age": "58",
                          "email": "john.doe@ucll.be",
                          "password": "john1235"
                        }
                        """)
                .exchange().expectStatus().is2xxSuccessful()
                .expectBody()
                .json("""
                    {"name":"Timmy Doe","age":58,"email":"john.doe@ucll.be","password":"john1235"}
                  """);

        User user = userRepository.findByEmail("john.doe@ucll.be").get();

        Assertions.assertEquals("Timmy Doe", user.getName());
        Assertions.assertEquals(58, user.getAge());
        Assertions.assertEquals("john.doe@ucll.be", user.getEmail());
        Assertions.assertEquals("john1235", user.getPassword());
    }

    @Test
    public void givenExistingUser_whenDeletingUser_thenUserIsRemovedFromDb() {
        webTestClient
                .delete()
                .uri("/users/john.doe@ucll.be")
                .exchange().expectStatus().is2xxSuccessful();

        Assertions.assertTrue(userRepository.findByEmail("john.doe@ucll.be").isEmpty());
    }

    // Story 02 tests

    @Test
    public void givenUsersWithProfiles_whenGetByInterestsScience_thenMatchingUsersReturned() {
        webTestClient
                .get()
                .uri("/users/interests/Science")
                .exchange().expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].email").isEqualTo("john.doe@ucll.be")
                .jsonPath("$[1].email").isEqualTo("birgit.doe@ucll.be");
    }

    @Test
    public void givenUsersWithProfiles_whenGetByInterestsThatMatchNobody_thenErrorIsReturned() {
        webTestClient
                .get()
                .uri("/users/interests/Skydiving")
                .exchange().expectStatus().isBadRequest()
                .expectBody()
                .jsonPath("$.error").isEqualTo("No users found with interests containing: Skydiving");
    }

    // Story 03 tests

    @Test
    public void givenUsersWithProfiles_whenGetOlderThan20WithScienceInterests_thenReturnedSortedByLocation() {
        webTestClient
                .get()
                .uri("/users/age/20/interests/Science")
                .exchange().expectStatus().isOk()
                .expectBody()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].email").isEqualTo("john.doe@ucll.be");
    }

    @Test
    public void givenUsersWithProfiles_whenGetOlderThan20WithScienceInterestsNoneMatch_thenErrorIsReturned() {
        webTestClient
                .get()
                .uri("/users/age/50/interests/Science")
                .exchange().expectStatus().isBadRequest()
                .expectBody()
                .jsonPath("$.error").isEqualTo("No users found older than 50 with interests containing: Science");
    }
}
