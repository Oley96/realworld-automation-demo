package io.demo.realworld.api;

import io.demo.realworld.data.StatusCode;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.demo.realworld.api.client.ApiClient.api;
import static io.demo.realworld.data.TestData.getFaker;
import static io.demo.realworld.data.TestData.prepareRandomArticle;
import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("oleynik")
@Feature("articles")
class ArticlesTests {

    @BeforeEach
    public void arrange() {
        api().auth().loginAsDefaultUser();
    }

    @Test
    @Tag("api")
    @DisplayName("create new article")
    void shouldCreateNewArticle() {
        var article = prepareRandomArticle();
        var actualArticle = api().articles().createArticle(article, StatusCode.OK);

        assertEquals(article.getBody(), actualArticle.getBody());
        assertEquals(article.getDescription(), actualArticle.getDescription());
        assertEquals(article.getTitle(), actualArticle.getTitle());
        assertEquals(article.getTagList(), actualArticle.getTagList());
    }

    @Test
    @Tag("api")
    @DisplayName("get new article by slug")
    void shouldGetArticleBySlug() {
        var newArticle = api().articles()
                .createArticle(prepareRandomArticle(), StatusCode.OK);

        var actualArticle = api().articles().getArticle(newArticle.getSlug(), StatusCode.OK);

        assertEquals(newArticle.getSlug(), actualArticle.getSlug());
        assertEquals(newArticle.getTitle(), actualArticle.getTitle());
    }

    @Test
    @Tag("api")
    @DisplayName("update existing article by slug")
    void shouldUpdateArticleBySlug() {
        var article = prepareRandomArticle();
        var newArticle = api().articles().createArticle(article, StatusCode.OK);

        article.setTitle(getFaker().random().hex(6));
        article.setBody("Updated body");
        article.setDescription("Updated description");

        var actualArticle = api().articles()
                .updateArticle(newArticle.getSlug(), article, StatusCode.OK);

        assertEquals(article.getBody(), actualArticle.getBody());
        assertEquals(article.getDescription(), actualArticle.getDescription());
        assertEquals(article.getTitle(), actualArticle.getTitle());
    }

    @Test
    @Tag("api")
    @DisplayName("delete existing article by slug")
    void shouldDeleteBySlug() {
        var newArticle = api().articles().createArticle(prepareRandomArticle(), StatusCode.OK);
        api().articles().deleteArticle(newArticle.getSlug(), StatusCode.NO_CONTENT);

        var actualArticle = api().articles().getArticle(newArticle.getSlug(), StatusCode.OK);

        assertEquals(emptyMap(), actualArticle.getAuthor());
    }
}