package io.demo.realworld.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("profile")
public class Profile {
    private String image;
    private boolean following;
    private String bio;
    private String username;
}