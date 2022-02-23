package com.cashtracksavings.cashtrackssavings.exception;

public class NoSavingsDataException extends BusinessException{

    public NoSavingsDataException(ErrorEnum errorEnum){ super(errorEnum); }

}
