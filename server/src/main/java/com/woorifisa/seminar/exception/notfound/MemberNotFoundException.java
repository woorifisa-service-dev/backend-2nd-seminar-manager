package com.woorifisa.seminar.exception.notfound;

import com.woorifisa.seminar.exception.BaseAbstractException;
import com.woorifisa.seminar.exception.code.ExceptionStatus;

public class MemberNotFoundException extends BaseAbstractException {

    public MemberNotFoundException() {
        super(ExceptionStatus.MEMBER_NOT_FOUND);
    }

}
