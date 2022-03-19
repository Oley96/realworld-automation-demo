package io.demo.realworld.config;

import io.demo.realworld.helper.ConfigHelper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import lombok.Getter;

import static io.demo.realworld.helper.ConfigHelper.*;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

@Getter
public class ApiConfig {

    private RequestSpecBuilder requestSpecBuilder;
    private ResponseSpecBuilder responseSpecBuilder;

    private ApiConfig() {
    }

    public static ApiConfig config() {
        return new ApiConfig();
    }

    public ApiConfig build() {
        this.requestSpecBuilder = new RequestSpecBuilder()
                .setContentType(JSON)
                .addFilter(new AllureRestAssured())
                .setBaseUri(APP_CONFIG.apiUrl())
                .setBasePath(APP_CONFIG.apiPath())
                .log(ALL);

        this.responseSpecBuilder = new ResponseSpecBuilder().log(ALL);
        return this;
    }
}
