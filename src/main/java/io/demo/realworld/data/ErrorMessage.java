package io.demo.realworld.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    INVALID_CREDENTIALS("email or password is invalid"),
    BLANK_PASSWORD("password can't be blank"),
    BLANK_EMAIL("email can't be blank");

    private final String message;
}
