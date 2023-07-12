package com.woorifisa.seminar.exception;

import com.woorifisa.seminar.exception.code.ExceptionStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class BaseAbstractException extends RuntimeException {

    protected final ExceptionStatus exceptionStatus;

}
