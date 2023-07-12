package com.woorifisa.seminar.exception.notfound;

import com.woorifisa.seminar.exception.BaseAbstractException;
import com.woorifisa.seminar.exception.code.ExceptionStatus;

public class EstimationItemNotFoundException extends BaseAbstractException {

    public EstimationItemNotFoundException() {
        super(ExceptionStatus.ESTIMATION_ITEM_NOT_FOUND);
    }

}
