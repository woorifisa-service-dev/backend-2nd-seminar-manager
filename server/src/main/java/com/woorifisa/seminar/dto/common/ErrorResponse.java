package com.woorifisa.seminar.dto.common;

import com.woorifisa.seminar.exception.code.ExceptionStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final Integer code;
    private final String message;

    public static ResponseEntity<ErrorResponse> fail(ExceptionStatus status) {
        return ResponseEntity.status(status.getHttpStatus())
                             .body(new ErrorResponse(status.getCode(), status.getMessage()));
    }

    public static ResponseEntity<ErrorResponse> failValidate(ExceptionStatus status, String message) {
        return ResponseEntity.status(status.getHttpStatus())
                             .body(new ErrorResponse(status.getCode(), status.getMessage()));
    }

}
