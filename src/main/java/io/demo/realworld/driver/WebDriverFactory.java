package io.demo.realworld.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.demo.realworld.helper.AttachHelper;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Configuration.browserCapabilities;
import static io.demo.realworld.helper.ConfigHelper.LAUNCH_CONFIG;

public class WebDriverFactory {

    public static void createDriverInstance() {
        switch (LAUNCH_CONFIG.launchMode()) {
            case "chrome.remote":
                Browser.REMOTE_CHROME.start();
                break;
            case "firefox.remote":
                Browser.REMOTE_FIREFOX.start();
                break;
            case "firefox.local":
                Browser.LOCAL_FIREFOX.start();
                break;
            default:
                Browser.LOCAL_CHROME.start();
        }
    }

    public static void shutdownDriverInstance() {
        AttachHelper.screenshotAs("Last screenshot");
        AttachHelper.pageSource();
        if (isRemoteWebDriver()) AttachHelper.addVideo();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    private static boolean isRemoteWebDriver() {
        return LAUNCH_CONFIG.launchMode().endsWith("remote");
    }

    private static void setRemoteCapabilities() {
        browserCapabilities.setCapability("noProxy", true);
        browserCapabilities.setCapability("enableVNC", true);
        browserCapabilities.setCapability("enableVideo", false);
    }

    private static void setRemoteInstance() {
        Configuration.remote = LAUNCH_CONFIG.remoteDriverUrl();
    }

    private enum Browser {
        REMOTE_CHROME {
            @Override
            void start() {
                setRemoteCapabilities();
                setRemoteInstance();
                Configuration.browser = CHROME;
            }
        },
        REMOTE_FIREFOX {
            @Override
            void start() {
                setRemoteCapabilities();
                setRemoteInstance();
                Configuration.browser = FIREFOX;
            }
        },
        LOCAL_CHROME {
            @Override
            void start() {
                Configuration.browser = CHROME;
            }
        },
        LOCAL_FIREFOX {
            @Override
            void start() {
                Configuration.browser = FIREFOX;
            }
        };

        abstract void start();
    }
}
