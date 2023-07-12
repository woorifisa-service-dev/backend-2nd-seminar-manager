package com.woorifisa.seminar.exception.code;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ExceptionStatus {

    LOGIN_FAIL(401000, UNAUTHORIZED, "아이디 또는 비밀번호를 확인해주세요");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

}
