package io.demo.realworld.api.client;

import io.demo.realworld.api.controller.ArticlesController;
import io.demo.realworld.api.controller.AuthController;
import io.demo.realworld.api.controller.ProfileController;
import io.demo.realworld.config.ApiConfig;

public class ApiClient {

    private ApiClient() {
    }

    public static ApiClient api() {
        return new ApiClient();
    }

    public AuthController auth() {
        return new AuthController(ApiConfig.config().build());
    }

    public ArticlesController articles() {
        return new ArticlesController(ApiConfig.config().build());
    }

    public ProfileController profile() {
        return new ProfileController(ApiConfig.config().build());
    }
}
