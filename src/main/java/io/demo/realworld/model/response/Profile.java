package io.demo.realworld.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
    private String image;
    private boolean following;
    private String bio;
    private String username;
}