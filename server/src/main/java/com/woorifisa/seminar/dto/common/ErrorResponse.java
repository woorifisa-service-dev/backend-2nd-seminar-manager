package com.woorifisa.seminar.dto.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final Integer code;
    private final String message;

    public static ResponseEntity<ErrorResponse> fail(HttpStatus status, String message) {
        return ResponseEntity.status(status)
                             .body(new ErrorResponse(status.value(), message));
    }

}
