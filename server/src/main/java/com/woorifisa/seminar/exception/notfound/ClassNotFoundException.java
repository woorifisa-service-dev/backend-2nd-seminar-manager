package com.woorifisa.seminar.exception.notfound;

import com.woorifisa.seminar.exception.BaseAbstractException;
import com.woorifisa.seminar.exception.code.ExceptionStatus;

public class ClassNotFoundException extends BaseAbstractException {

    public ClassNotFoundException() {
        super(ExceptionStatus.CLASS_NOT_FOUND);
    }

}
