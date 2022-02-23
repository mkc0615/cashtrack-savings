package com.cashtracksavings.cashtrackssavings.exception;

public class NoStockDataException extends BusinessException{

    public NoStockDataException(ErrorEnum errorEnum){ super(errorEnum); }

}
