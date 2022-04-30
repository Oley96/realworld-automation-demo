package io.demo.realworld.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("article")
public class Article {
    private List<String> tagList;
    private String createdAt;
    private String description;
    private String title;
    private String body;
    private int favoritesCount;
    private String slug;
    private String updatedAt;
    private boolean favorited;
    private Map<String, Object> author;
}
