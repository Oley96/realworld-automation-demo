package io.demo.realworld.api.controller;

import io.demo.realworld.config.ApiConfig;
import io.demo.realworld.data.Endpoints;
import io.demo.realworld.data.StatusCode;
import io.demo.realworld.model.request.UpdateUser;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ProfileController extends ApiController {

    public ProfileController(ApiConfig config) {
        super(config);
    }

    @Step("Get profile by {0}")
    public Response getProfileInfo(String username, StatusCode statusCode) {
        requestSpecBuilder.addHeaders(getAuthHeader()).addPathParam("username", username);
        responseSpecBuilder.expectStatusCode(statusCode.getCode());

        return get(Endpoints.GET_USER_PROFILE.getPath());
    }

    @Step("Update user info")
    public void updateProfile(UpdateUser payload, StatusCode statusCode) {
        requestSpecBuilder.addHeaders(getAuthHeader()).setBody(payload);
        responseSpecBuilder.expectStatusCode(statusCode.getCode());

        put(Endpoints.UPDATE_USER_PROFILE.getPath());
    }
}