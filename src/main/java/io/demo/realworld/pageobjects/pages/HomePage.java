package io.demo.realworld.pageobjects.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import io.demo.realworld.pageobjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HomePage extends Page {

    @Step("Open home page")
    public HomePage open() {
        return navigate("/", HomePage.class);
    }

    @Step("Go to global feed")
    public HomePage goToGlobalFeed() {
        $(Selectors.byText("Global Feed")).click();
        return this;
    }

    @Step("Go to first author profile page")
    public void goToFirstAuthorProfilePage() {
        $$(".article-preview").first().$("a[ui-sref*='app.profile']").click();
    }

    @Step("Go to author {0} page")
    public void goToAuthorProfilePage(String author) {
        Selenide.open("/#/@" + author);
    }
}
