package tests;

import api.AuthorizationAPI;
import models.AuthModel;
import org.junit.jupiter.api.Test;

import static tests.TestData.credentials;
import static tests.TestData.profilePage;



public class LoginTest extends BaseTest {

    @Test
    void successfulLogin() {
        AuthModel authModel = AuthorizationAPI.login(credentials);
        profilePage.openWithCookie(authModel);
        profilePage.checkUserName(credentials.getUserName());
    }

}
