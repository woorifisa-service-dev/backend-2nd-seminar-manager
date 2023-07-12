package com.woorifisa.seminar.exception;

import com.woorifisa.seminar.exception.code.ExceptionStatus;

public class LoginFailException extends BaseAbstractException{

    public LoginFailException() {
        super(ExceptionStatus.LOGIN_FAIL);
    }

}
