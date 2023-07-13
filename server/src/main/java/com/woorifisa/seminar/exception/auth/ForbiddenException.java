package com.woorifisa.seminar.exception.auth;

import com.woorifisa.seminar.exception.BaseAbstractException;
import com.woorifisa.seminar.exception.code.ExceptionStatus;

public class ForbiddenException extends BaseAbstractException {

    public ForbiddenException() {
        super(ExceptionStatus.FORBIDDEN_ROLE);
    }

}