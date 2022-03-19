package io.demo.realworld.model.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginUser {
    String email;
    String password;
}
