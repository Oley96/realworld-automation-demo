package io.demo.realworld.ui;

import io.demo.realworld.TestBase;
import io.demo.realworld.data.ErrorMessage;
import io.demo.realworld.extention.WithLogin;
import io.demo.realworld.helper.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.demo.realworld.data.TestData.getFaker;

@Feature("auth")
class AuthTests extends TestBase {

    @Test
    @Tag("UI")
    @DisplayName("login with valid credentials")
    void shouldLoginWithValidCredentials() {
        loginPage.open()
                .typeEmail(ConfigHelper.APP_CONFIG.defaultLogin())
                .typePassword(ConfigHelper.APP_CONFIG.defaultPassword())
                .clickSignIn()
                .getNavBar().checkUsernameEquals("oleynik96");
    }

    @Test
    @Tag("UI")
    @DisplayName("login with invalid credentials")
    void shouldPresentErrorMessageInvalidCredentials() {
        loginPage.open()
                .typeEmail(ConfigHelper.APP_CONFIG.defaultLogin())
                .typePassword(getFaker().internet().password())
                .clickSignIn()
                .checkErrorMessagePresent(ErrorMessage.INVALID_CREDENTIALS);
    }

    @Test
    @Tag("UI")
    @DisplayName("login with invalid credentials. Blank password")
    void shouldPresentErrorMessageEmptyPassword() {
        loginPage.open()
                .typeEmail(ConfigHelper.APP_CONFIG.defaultLogin())
                .clickSignIn()
                .checkErrorMessagePresent(ErrorMessage.BLANK_PASSWORD);
    }

    @Test
    @Tag("UI")
    @DisplayName("login with invalid credentials. Blank email")
    void shouldPresentErrorMessageEmptyEmail() {
        loginPage.open()
                .typePassword(getFaker().internet().password())
                .clickSignIn()
                .checkErrorMessagePresent(ErrorMessage.BLANK_EMAIL);
    }

    @Test
    @WithLogin
    @Tags({@Tag("api"), @Tag("UI")})
    @DisplayName("login with via API")
    void shouldLoginViaAPI() {
        homePage.open().getNavBar().checkUsernameEquals("oleynik96");
    }

    @Test
    @Tag("UI")
    @DisplayName("should register with valid credentials")
    void shouldRegister() {
        String username = getFaker().name().username();

        signUpPage.open()
                .typeUserName(username)
                .typeEmail(getFaker().internet().emailAddress())
                .typePassword(getFaker().internet().password())
                .clickSignIn();

        homePage.getNavBar().checkUsernameEquals(username);
    }
}