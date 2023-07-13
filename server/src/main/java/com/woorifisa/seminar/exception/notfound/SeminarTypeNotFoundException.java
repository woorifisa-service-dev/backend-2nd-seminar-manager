package com.woorifisa.seminar.exception.notfound;

import com.woorifisa.seminar.exception.BaseAbstractException;
import com.woorifisa.seminar.exception.code.ExceptionStatus;

public class SeminarTypeNotFoundException extends BaseAbstractException {

    public SeminarTypeNotFoundException() {
        super(ExceptionStatus.SEMINAR_TYPE_NOT_FOUND);
    }

}
