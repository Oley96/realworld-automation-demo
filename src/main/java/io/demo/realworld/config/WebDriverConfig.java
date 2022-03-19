package io.demo.realworld.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static io.demo.realworld.helper.ConfigHelper.APP_CONFIG;
import static io.demo.realworld.helper.ConfigHelper.LAUNCH_CONFIG;
import static io.qameta.allure.selenide.LogType.BROWSER;
import static java.util.logging.Level.ALL;

public final class WebDriverConfig {

    private WebDriverConfig() {
    }

    public static void buildConfig() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true)
                .savePageSource(false)
                .enableLogs(BROWSER, ALL));

        Configuration.baseUrl = APP_CONFIG.webUrl();
        Configuration.timeout = LAUNCH_CONFIG.timeout();
        Configuration.browserSize = LAUNCH_CONFIG.browserSize();
    }
}
