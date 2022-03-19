package io.demo.realworld;

import io.demo.realworld.pageobjects.pages.HomePage;
import io.demo.realworld.pageobjects.pages.LoginPage;
import io.demo.realworld.pageobjects.pages.ProfilePage;
import io.demo.realworld.pageobjects.pages.SignUpPage;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.demo.realworld.config.WebDriverConfig.buildConfig;
import static io.demo.realworld.driver.WebDriverFactory.createDriverInstance;
import static io.demo.realworld.driver.WebDriverFactory.shutdownDriverInstance;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    protected LoginPage loginPage = new LoginPage();
    protected HomePage homePage = new HomePage();
    protected ProfilePage profilePage = new ProfilePage();
    protected SignUpPage signUpPage = new SignUpPage();

    @BeforeAll
    static void beforeAll() {
        buildConfig();
    }

    @BeforeEach
    void beforeEach() {
        createDriverInstance();
    }

    @AfterEach
    public void addAttachments() {
        shutdownDriverInstance();
    }
}
