package com.woorifisa.seminar.exception.advice;

import static com.woorifisa.seminar.exception.code.ExceptionStatus.*;

import com.woorifisa.seminar.dto.common.ErrorResponse;
import com.woorifisa.seminar.exception.BaseAbstractException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 전역 예외 처리
 */
@Slf4j
@RestControllerAdvice
public class GlobalRestControllerAdvice {

    @ExceptionHandler(BaseAbstractException.class)
    public ResponseEntity<ErrorResponse> handleGlobalCustomException(BaseAbstractException e) {
        return ErrorResponse.fail(e.getExceptionStatus());
    }

    // 유효성 검사 통과 실패 (Controller의 @Validate)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidateException(MethodArgumentNotValidException e) {

        StringBuilder sb = new StringBuilder();
        e.getBindingResult()
         .getAllErrors()
         .forEach(errorInfo -> sb.append(errorInfo).append("\n"));

        return ErrorResponse.failValidate(VALIDATION_FAIL, sb.toString());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalServerException(Exception e) {
        e.printStackTrace();
    	return ErrorResponse.fail(SERVER_EXCEPTION);
    }

}
