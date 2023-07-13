package com.woorifisa.seminar.exception.notfound;

import com.woorifisa.seminar.exception.BaseAbstractException;
import com.woorifisa.seminar.exception.code.ExceptionStatus;

public class SubjectNotFoundException extends BaseAbstractException {

    public SubjectNotFoundException() {
        super(ExceptionStatus.SEMINAR_SUBJECT_NOT_FOUND);
    }

}
