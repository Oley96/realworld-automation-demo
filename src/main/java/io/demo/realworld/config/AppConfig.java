package io.demo.realworld.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/app.properties"})
public interface AppConfig extends Config {

    @Key("app.user.default.login")
    String defaultLogin();

    @Key("app.user.default.password")
    String defaultPassword();

    @Key("app.web.url")
    String webUrl();

    @Key("app.api.url")
    String apiUrl();

    @Key("app.api.path")
    String apiPath();
}
