package io.demo.realworld.extention;

import io.demo.realworld.data.StatusCode;
import io.demo.realworld.model.request.LoginUser;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.open;
import static io.demo.realworld.api.client.ApiClient.api;
import static io.demo.realworld.helper.ConfigHelper.APP_CONFIG;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        LoginUser user = LoginUser.builder()
                .email(APP_CONFIG.defaultLogin())
                .password(APP_CONFIG.defaultPassword())
                .build();

        String authResponse = api().auth().login(user, StatusCode.OK).path("user.token");

        open("/favicon.ico");
        localStorage().setItem("jwtToken", authResponse);
    }
}
