package io.demo.realworld.api.controller;

import io.demo.realworld.config.ApiConfig;
import io.demo.realworld.data.Endpoints;
import io.demo.realworld.data.StatusCode;
import io.demo.realworld.data.TestData;
import io.demo.realworld.model.request.LoginUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AuthController extends ApiController {
    private static final String AUTH_WRAPPER_KEY = "user";


    public AuthController(ApiConfig config) {
        super(config);
    }

    @Step("Login user")
    public Response login(LoginUser payload, StatusCode statusCode) {
        requestSpecBuilder.setBody(wrapRequestPayload(AUTH_WRAPPER_KEY, payload));
        responseSpecBuilder.expectStatusCode(statusCode.getCode());

        var response = post(Endpoints.LOGIN_USER.getPath());
        setToken(response.path("user.token"));

        return response;
    }

    @Step("Login as default user")
    public void loginAsDefaultUser() {
        login(TestData.defaultUser(), StatusCode.OK);
    }
}