package io.demo.realworld.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CreateArticle {
    private List<String> tagList;
    private String description;
    private String title;
    private String body;
}
