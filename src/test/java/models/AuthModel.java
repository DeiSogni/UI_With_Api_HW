package models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthModel {
        private String userId, username, password, token, expires, created_date, isActive;
}
