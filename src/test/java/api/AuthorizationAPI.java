package api;

import io.restassured.http.ContentType;
import models.AuthModel;
import models.CredentialsModel;

import static io.restassured.RestAssured.given;

public class AuthorizationAPI {

    public static AuthModel login(CredentialsModel credentials) {
        return given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("/Account/v1/Login")
                .then()
                .statusCode(200)
                .extract()
                .as(AuthModel.class);
    }
}
