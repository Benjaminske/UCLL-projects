package be.ucll.controller;

import be.ucll.repository.DBInitializer;
import be.ucll.repository.PonyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Sql("classpath:schema.sql")
public class PonyControllerTest {

    private WebTestClient client;
    private PonyRepository ponyRepository;
    private DBInitializer dbInitializer;

    @Autowired
    public PonyControllerTest(WebTestClient client, PonyRepository ponyRepository, DBInitializer dbInitializer) {
        this.client = client;
        this.ponyRepository = ponyRepository;
        this.dbInitializer = dbInitializer;
    }

    @BeforeEach
    public void resetRepository () {
        dbInitializer.intialize();
    }


    @Test
    public void givenDataInJsonFormatForNewPony_whenPostRequest_thenPonyIsAddedAnd200OKAndNothingReturnedInBodyOfResponse () {
        client.post()
                .uri("/pony")
                .header("Content-Type", "application/json")
                .bodyValue("{\n" +
                        "        \"name\": \"Elke\",\n" +
                        "        \"age\": 12\n" +
                        "}")
                .exchange()
                .expectStatus().is2xxSuccessful();

        assertEquals("Elke", ponyRepository.findByName("Elke").get().getName());
    }

    @Test
    public void given2Ponies_whenGetRequest_then2PoniesInJsonFormatReturned () {
        client.get()
                .uri("/pony")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .json("""
                    [
                        {
                            "name": "Bella",
                            "age": 5
                        },
                        {
                            "name": "Luna",
                            "age": 7
                        }
                    ]
                  """);
//                .json("[\n" +
//                        "    {\n" +
//                        "        \"name\": \"Bella\",\n" +
//                        "        \"age\": 5\n" +
//                        "    },\n" +
//                        "    {\n" +
//                        "        \"name\": \"Luna\",\n" +
//                        "        \"age\": 7\n" +
//                        "    }\n" +
//                        "]");

    }

}
