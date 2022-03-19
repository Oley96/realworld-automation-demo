package io.demo.realworld.api.controller;

import io.demo.realworld.config.ApiConfig;
import io.demo.realworld.data.Endpoints;
import io.demo.realworld.data.StatusCode;
import io.demo.realworld.model.request.CreateArticle;
import io.demo.realworld.model.response.Article;
import io.qameta.allure.Step;

public class ArticlesController extends ApiController {
    private static final String ARTICLE_WRAPPER_KEY = "article";

    public ArticlesController(ApiConfig config) {
        super(config);
    }

    @Step("Create article")
    public Article createArticle(CreateArticle payload, StatusCode statusCode) {
        requestSpecBuilder.addHeaders(getAuthHeader()).setBody((wrapRequestPayload(ARTICLE_WRAPPER_KEY, payload)));
        responseSpecBuilder.expectStatusCode(statusCode.getCode());

        return post(Endpoints.CREATE_ARTICLE.getPath())
                .then()
                .extract().body()
                .jsonPath()
                .getObject(ARTICLE_WRAPPER_KEY, Article.class);
    }

    @Step("Get article by slug {0}")
    public Article getArticle(String slug, StatusCode statusCode) {
        requestSpecBuilder.addHeaders(getAuthHeader()).addPathParam("slug", slug);
        responseSpecBuilder.expectStatusCode(statusCode.getCode());

        return get(Endpoints.GET_ARTICLE.getPath())
                .then()
                .extract().body()
                .jsonPath()
                .getObject(ARTICLE_WRAPPER_KEY, Article.class);
    }

    @Step("Update article by slug {0}")
    public Article updateArticle(String slug, CreateArticle payload, StatusCode statusCode) {
        requestSpecBuilder.addHeaders(getAuthHeader()).addPathParam("slug", slug)
                .setBody(wrapRequestPayload(ARTICLE_WRAPPER_KEY, payload));
        responseSpecBuilder.expectStatusCode(statusCode.getCode());

        return put(Endpoints.UPDATE_ARTICLE.getPath())
                .then()
                .extract().body()
                .jsonPath()
                .getObject(ARTICLE_WRAPPER_KEY, Article.class);
    }

    @Step("Delete article by slug {0}")
    public void deleteArticle(String slug, StatusCode statusCode) {
        requestSpecBuilder.addHeaders(getAuthHeader()).addPathParam("slug", slug);
        responseSpecBuilder.expectStatusCode(statusCode.getCode());

        delete(Endpoints.DELETE_ARTICLE.getPath());
    }
}
