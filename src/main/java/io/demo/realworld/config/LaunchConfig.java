package io.demo.realworld.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/launch.properties",
})
public interface LaunchConfig extends Config {

    @Key("browser.size")
    String browserSize();

    @Key("browser.timeout")
    Integer timeout();

    @Key("remote.driver.url")
    String remoteDriverUrl();

    @Key("remote.video.url")
    String remoteVideoUrl();

    @Key("launch")
    @DefaultValue("chrome.remote")
    String launchMode();
}
