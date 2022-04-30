package io.demo.realworld.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import lombok.Getter;

import static io.demo.realworld.helper.ConfigHelper.APP_CONFIG;
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


        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(
                new ObjectMapperConfig().jackson2ObjectMapperFactory((cls, charset) -> {
                            ObjectMapper om = new ObjectMapper().findAndRegisterModules();
                            om.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
                            return om;
                        }
                ));

        return this;
    }
}
