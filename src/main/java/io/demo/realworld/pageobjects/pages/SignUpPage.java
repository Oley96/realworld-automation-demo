package io.demo.realworld.pageobjects.pages;

import io.demo.realworld.pageobjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage extends Page {

    @Step("Open sign up page")
    public SignUpPage open() {
        return navigate("/#/register", SignUpPage.class);
    }

    @Step("Type username {0}")
    public SignUpPage typeUserName(String username) {
        $("input[type='text']").setValue(username);
        return this;
    }

    @Step("Type email {0}")
    public SignUpPage typeEmail(String email) {
        $("input[type='email']").setValue(email);
        return this;
    }

    @Step("Type password {0}")
    public SignUpPage typePassword(String password) {
        $("input[type='password']").setValue(password);
        return this;
    }

    @Step("Click submit button")
    public HomePage clickSignIn() {
        $("button[type='submit']").click();
        return new HomePage();
    }
}