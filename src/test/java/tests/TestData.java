package tests;

import models.CredentialsModel;
import models.IsbnModel;
import pages.ProfilePage;

public class TestData {

    private static String
            login = "few",
            password = "Test1234!",
            isbn = "9781449325862";

    public static CredentialsModel credentials = new CredentialsModel(login, password);
    public static IsbnModel isbnModel = new IsbnModel(isbn);
    public static ProfilePage profilePage = new ProfilePage();
}
