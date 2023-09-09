package tests;

import api.AuthorizationAPI;
import api.BooksAPI;
import models.AddBooksListModel;
import models.AuthModel;
import models.BookModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static tests.TestData.*;

public class ProfileBooksListTests extends BaseTest{

    @Test
    void addBookList() {
        AuthModel authModel = AuthorizationAPI.login(credentials);
        BooksAPI.deleteAllBooks(authModel.getUserId(), authModel.getToken());
        AddBooksListModel booksList = new AddBooksListModel(authModel.getUserId(), List.of(isbnModel));
        BooksAPI.addBooks(authModel.getToken(), booksList);
        profilePage.openWithCookie(authModel);
        profilePage.checkIfBookIsAdded("[id='see-book-Git Pocket Guide']");
    }

    @Test
    void deleteBook() {
        AuthModel authModel = AuthorizationAPI.login(credentials);
        BooksAPI.deleteAllBooks(authModel.getUserId(), authModel.getToken());
        AddBooksListModel booksList = new AddBooksListModel(authModel.getUserId(), List.of(isbnModel));
        BooksAPI.addBooks(authModel.getToken(), booksList);
        BooksAPI.deleteBook(
                new BookModel(isbnModel.getIsbn(), authModel.getUserId()),
                authModel.getToken()
        );
        profilePage.openWithCookie(authModel);
        profilePage.noRowsCheck();
    }

}
