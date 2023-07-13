package com.woorifisa.seminar.exception.auth;

import com.woorifisa.seminar.exception.BaseAbstractException;
import com.woorifisa.seminar.exception.code.ExceptionStatus;

public class LoginFailException extends BaseAbstractException {

    public LoginFailException() {
        super(ExceptionStatus.LOGIN_FAIL);
    }

}