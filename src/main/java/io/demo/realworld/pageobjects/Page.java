package io.demo.realworld.pageobjects;

import io.demo.realworld.pageobjects.components.NavBar;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.open;

@Slf4j
@Getter
public abstract class Page {

    protected final NavBar navBar = new NavBar();

    @Step("navigate to page : '{0}' - '{1}'")
    protected <T extends Page> T navigate(String url, Class<T> pageClass) {
        log.info("navigate to : \n " + pageClass.getSimpleName());
        return open(url, pageClass);
    }
}