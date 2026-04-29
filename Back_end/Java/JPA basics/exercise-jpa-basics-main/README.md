# Exercises JPA Basics

## Exercise 1

We will change the application so that it uses an H2 database instead of an in-memory List for storing courses.

You can do this by completing the following tasks:

1. Add the dependency for `H2` to the `pom.xml` file
1. Add the necessary properties to `application.properties`
1. Create a `schema.sql` file that contains SQL to create a database schema that matches the configuration of the `Course` entity
1. Change the `CourseRepository` to an interface extending `JPARepository`
   * Change the method call in the `CourseService` to the correct method of the `CourseRepository`
1. Create a `DbInitializer` class that preps the database with the following data on start-up:
    * Back-End Development, 6 credits, semester 2
    * Workplace Project Junior, 6 credits, semester 3
    * Full-Stack Development, 6 credits, semester 3
    * Workplace Project Senior, 6 credits, semester 5
    * Front-End Development, 6 credits, semester 1

The application should start, and you should see the data in the database after start-up (verify this with the H2-console).

Verify that the course endpoint still works as described below:

| Field                    | Details                                                |
|:-------------------------|:-------------------------------------------------------|
| **Request**              | GET                                                    |
| **URL**                  | `http://localhost:8080/course`                         |
| **Request Parameter**    | None                                                   |
| **Output: happy case**   | A JSON list of courses with all fields present         |
| **Output: unhappy case** | An empty list when no courses are present              |
| **Acceptance Criteria**  | Returns a JSON list of courses with all fields present |

## Exercise 2

Implement the following endpoint:

| Field                    | Details                                                                    |
|:-------------------------|:---------------------------------------------------------------------------|
| **Request**              | GET                                                                        |
| **URL**                  | `http://localhost:8080/course/{id}`                                        |
| **Request Parameter**    | The id of the course that should be returned                               |
| **Output: happy case**   | The data of the course with id {id}                                        |
| **Output: unhappy case** | A formatted message that says that the course with {id} could not be found |
| **Acceptance Criteria**  | No additional acceptance criteria                                          |

The only new part is finding the appropriate repository method in your JPARepository. You should not add a method to your repository for this endpoint, use a built-in method.

## Exercise 3

Implement the following endpoint:

| Field                    | Details                                                        |
|:-------------------------|:---------------------------------------------------------------|
| **Request**              | GET                                                            |
| **URL**                  | `http://localhost:8080/course/semester/{semester}`             |
| **Request Parameter**    | The semester that the returned courses should take place in    |
| **Output: happy case**   | A JSON list of courses with all fields present                 |
| **Output: unhappy case** | An empty list when no courses are found for the given semester |
| **Acceptance Criteria**  | No additional acceptance criteria                              |

The only new part is finding the appropriate repository method in your JPARepository. You should add a new method to your repository for this endpoint.

## Exercise 4

Implement the following endpoint:

| Field                    | Details                                                                    |
|:-------------------------|:---------------------------------------------------------------------------|
| **Request**              | PUT                                                                        |
| **URL**                  | `http://localhost:8080/course/{id}`                                        |
| **Request Parameter**    | The id of the course that should be updated                                |
| **Output: happy case**   | The course with the updated fields                                         |
| **Output: unhappy case** | A formatted message that says that the course with {id} could not be found |
| **Acceptance Criteria**  | The ID cannot be updated through this endpoint                             |

The only new part is finding the appropriate repository method in your JPARepository. You should not add a method to your repository for this endpoint, use a built-in method.

## Exercise 5

Implement the following endpoint:

| Field                    | Details                                                                    |
|:-------------------------|:---------------------------------------------------------------------------|
| **Request**              | DELETE                                                                     |
| **URL**                  | `http://localhost:8080/course/{id}`                                        |
| **Request Parameter**    | The id of the course that should be deleted                                |
| **Output: happy case**   | No value needs to be returned                                              |
| **Output: unhappy case** | A formatted message that says that the course with {id} could not be found |
| **Acceptance Criteria**  | No additional acceptance criteria                                          |

The only new part is finding the appropriate repository method in your JPARepository. You should not add a method to your repository for this endpoint, use a built-in method.

## Exercise 6

Implement the following endpoint:

| Field                    | Details                                                                                                             |
|:-------------------------|:--------------------------------------------------------------------------------------------------------------------|
| **Request**              | GET                                                                                                                 |
| **URL**                  | `http://localhost:8080/course/searchandorder/{title}`                                                               |
| **Request Parameter**    | A string title representing a part of the title of certain courses                                                  |
| **Output: happy case**   | A JSON list of courses that contain the parameter `title` in their title (case insensitive) with all fields present |
| **Output: unhappy case** | An empty list when no courses are found for the given title                                                         |
| **Acceptance Criteria**  | Courses should be ordered by semester                                                                               |

The only new part is finding the appropriate repository method in your JPARepository. You should add a new method to your repository for this endpoint.

## Exercise 7

Implement the following endpoint:

| Field                    | Details                                                                                                           |
|:-------------------------|:------------------------------------------------------------------------------------------------------------------|
| **Request**              | GET                                                                                                               |
| **URL**                  | `http://localhost:8080/course/search?betweensemester={semester1}&semester={semester2}`                            |
| **Request Parameter**    | Two request variables that represent the range of semesters to search in                                          |
| **Output: happy case**   | A JSON list of courses that fall between the provided semesters (bounds **not** included) with all fields present |
| **Output: unhappy case** | An empty list when no courses are found for the given title                                                       |
| **Acceptance Criteria**  | Courses should be ordered by semester                                                                             |

The only new part is finding the appropriate repository method in your JPARepository. You should add a new method to your repository for this endpoint.