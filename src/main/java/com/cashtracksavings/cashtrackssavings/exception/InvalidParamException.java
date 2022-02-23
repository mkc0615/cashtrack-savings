package com.cashtracksavings.cashtrackssavings.exception;

public class InvalidParamException extends BusinessException {

    public InvalidParamException(ErrorEnum errorEnum){ super(errorEnum); }

}
