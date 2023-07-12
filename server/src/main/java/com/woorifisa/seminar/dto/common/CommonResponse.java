package com.woorifisa.seminar.dto.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequiredArgsConstructor
@Getter
public class CommonResponse<T> {

    private final Integer code;
    private final T data;

    public static <T> ResponseEntity<CommonResponse<T>> create(HttpStatus status, T data) {
        return ResponseEntity.status(status).body(new CommonResponse<>(status.value(), data));
    }

}
