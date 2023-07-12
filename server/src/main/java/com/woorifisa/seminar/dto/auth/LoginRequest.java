package com.woorifisa.seminar.dto.auth;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;

}