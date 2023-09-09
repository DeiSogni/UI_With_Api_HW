package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddBooksListModel {

    private String userId;
    @JsonProperty("collectionOfIsbns")
    private List<IsbnModel> booksCollection;

}
