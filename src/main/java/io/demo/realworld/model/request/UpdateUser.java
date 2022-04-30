package io.demo.realworld.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonRootName("user")
public class UpdateUser {
    String bio;
}
