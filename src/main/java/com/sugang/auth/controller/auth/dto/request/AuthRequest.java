package com.sugang.auth.controller.auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AuthRequest {

    @NotEmpty
    @NotNull
    private String code;
}