package api;

import io.restassured.http.ContentType;
import models.AddBooksListModel;
import models.BookModel;

import static io.restassured.RestAssured.given;

public class BooksAPI {

    public static void deleteAllBooks(String userId, String token) {
        given()
                .accept("application/json")
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .queryParam("UserId", userId)
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .statusCode(204);
    }

    public static void addBooks(String token, AddBooksListModel booksList) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(booksList)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .statusCode(201);
    }

    public static void deleteBook(BookModel book, String token) {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(book)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .statusCode(204);
    }
}
