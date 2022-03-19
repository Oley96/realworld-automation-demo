package io.demo.realworld.model.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateUser {
    String bio;
}
