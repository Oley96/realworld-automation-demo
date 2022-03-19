package io.demo.realworld.pageobjects.pages;

import com.codeborne.selenide.Selectors;
import io.demo.realworld.data.ErrorMessage;
import io.demo.realworld.pageobjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends Page {

    @Step("Open login page")
    public LoginPage open() {
        return navigate("/#/login", LoginPage.class);
    }

    @Step("Type email {0}")
    public LoginPage typeEmail(String email) {
        $("input[type='email']").setValue(email);
        return this;
    }

    @Step("Type password {0}")
    public LoginPage typePassword(String password) {
        $("input[type='password']").setValue(password);
        return this;
    }

    @Step("Click sign in button")
    public LoginPage clickSignIn() {
        $("button[type='submit']").click();
        return this;
    }

    @Step("Check error message {0} present")
    public void checkErrorMessagePresent(ErrorMessage errorMessage) {
        $(Selectors.byText(errorMessage.getMessage())).shouldBe(visible);
    }
}