package com.woorifisa.seminar.exception.code;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ExceptionStatus {

    VALIDATION_FAIL(400101, BAD_REQUEST, ""),

    LOGIN_FAIL(401101, UNAUTHORIZED, "아이디 또는 비밀번호를 확인해주세요"),

    FORBIDDEN_ROLE(403101, FORBIDDEN, "권한이 없습니다."),

    CLASS_NOT_FOUND(404101, NOT_FOUND, "해당 반을 찾을 수 없습니다."),
    ESTIMATION_ITEM_NOT_FOUND(404201, NOT_FOUND, "평가 항목을 찾을 수 없습니다."),
    MEMBER_NOT_FOUND(404301, NOT_FOUND, "해당 회원을 찾을 수 없습니다."),
    OTHER_ESTIMATION_NOT_FOUND(404401, NOT_FOUND, "평가 내역을 찾을 수 없습니다."),
    OTHER_ESTIMATION_ITEM_NOT_FOUND(404402, NOT_FOUND, "평가 항목을 찾을 수 없습니다."),
    ROLE_NOT_FOUND(404501, NOT_FOUND, "권한을 찾을 수 없습니다."),
    SEMINAR_TYPE_NOT_FOUND(404601, NOT_FOUND, "진행된 세미나를 찾을 수 없습니다."),
    SEMINAR_SUBJECT_NOT_FOUND(404602, NOT_FOUND, "세미나의 주제를 찾을 수 없습니다."),
    TEAM_NOT_FOUND(404603, NOT_FOUND, "잘못된 주제를 선택했습니다."),
    TEAM_ESTIMATION_NOT_FOUND(404701, NOT_FOUND, "자체평가를 내역을 찾을 수 없습니다."),
    TEAM_ESTIMATION_ITEM_NOT_FOUND(404702, NOT_FOUND, "자체 평가 항목을 찾을 수 없습니다."),

    SERVER_EXCEPTION(500101, INTERNAL_SERVER_ERROR, "서버에 오류가 발생했습니다. 죄송합니다."),
    ;

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

}
