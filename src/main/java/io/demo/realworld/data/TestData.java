package io.demo.realworld.data;

import com.github.javafaker.Faker;
import io.demo.realworld.model.request.CreateArticle;
import io.demo.realworld.model.request.LoginUser;

import java.util.List;

import static io.demo.realworld.helper.ConfigHelper.APP_CONFIG;

public class TestData {

    private TestData() {
    }

    public static LoginUser defaultUser() {
        return LoginUser.builder()
                .email(APP_CONFIG.defaultLogin())
                .password(APP_CONFIG.defaultPassword())
                .build();
    }

    public static CreateArticle prepareRandomArticle() {
        return CreateArticle.builder()
                .title(getFaker().random().hex(6))
                .body(getFaker().random().hex(20))
                .description(getFaker().random().hex(20))
                .tagList(List.of(getFaker().random().hex(5), getFaker().random().hex(5)))
                .build();
    }

    public static Faker getFaker() {
        return new Faker();
    }
}