package io.demo.realworld.api.controller;

import io.demo.realworld.config.ApiConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

import java.util.Collections;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.StringUtils.SPACE;

public class ApiController {
    private static final String AUTH_HEADER_NAME = "authorization";
    private static final String AUTH_HEADER_PREFIX = "Token";
    private static final ThreadLocal<String> TOKEN = new ThreadLocal<>();

    protected RequestSpecBuilder requestSpecBuilder;
    protected ResponseSpecBuilder responseSpecBuilder;

    protected ApiController(ApiConfig config) {
        this.requestSpecBuilder = config.getRequestSpecBuilder();
        this.responseSpecBuilder = config.getResponseSpecBuilder();
    }

    protected Map<String, String> getAuthHeader() {
        return Collections.singletonMap(AUTH_HEADER_NAME, AUTH_HEADER_PREFIX + " " + TOKEN.get());
    }

    protected void setToken(String token) {
        TOKEN.set(token);
    }

    protected Response post(String url) {
        return given()
                .spec(requestSpecBuilder.build())
                .post(url)
                .then()
                .spec(responseSpecBuilder.build())
                .extract()
                .response();
    }

    protected Response get(String url) {
        return given()
                .spec(requestSpecBuilder.build())
                .get(url)
                .then()
                .spec(responseSpecBuilder.build())
                .extract()
                .response();
    }

    protected void delete(String url) {
        given()
                .spec(requestSpecBuilder.build())
                .delete(url)
                .then()
                .spec(responseSpecBuilder.build())
                .extract()
                .response();
    }

    protected Response put(String url) {
        return given()
                .spec(requestSpecBuilder.build())
                .put(url)
                .then()
                .spec(responseSpecBuilder.build())
                .extract()
                .response();
    }

    // @formatter:off
    /**
     * given JSON payload:
     * {
     *     "title": "Hello World"
     * }
     * @param payloadWrapperKey key to wrap request payload. For instance "article"
     * @param payload JSON body to be wrapped
     * @return wrapped payload:
     * {
     *     "article": {
     *         "title": "Hello World"
     *     }
     * }
     */
    // @formatter:on
    protected Map<String, Object> wrapRequestPayload(String payloadWrapperKey, Object payload) {
        return Collections.singletonMap(payloadWrapperKey, payload);
    }
}
