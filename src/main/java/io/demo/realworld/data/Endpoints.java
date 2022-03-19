package io.demo.realworld.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Endpoints {
    //auth
    LOGIN_USER("/users/login"),

    //articles
    CREATE_ARTICLE("/articles"),
    GET_ARTICLE("/articles/{slug}"),
    UPDATE_ARTICLE("/articles/{slug}"),
    DELETE_ARTICLE("/articles/{slug}"),

    //profile
    GET_USER_PROFILE("/profiles/{username}"),
    UPDATE_USER_PROFILE("/user");

    private final String path;
}
