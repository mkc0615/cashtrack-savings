package com.cashtracksavings.cashtrackssavings.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SavingsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { InvalidParamException.class })
    protected ResponseEntity<ErrorResponse> handleInvalidParamException(){
        return ErrorResponse.createResponseEntity(ErrorEnum.INVALID_PARAMETER);
    }

    @ExceptionHandler(value= { NoSavingsDataException.class })
    protected ResponseEntity<ErrorResponse> handleNoSavingsException(){
        return ErrorResponse.createResponseEntity(ErrorEnum.DATA_NOT_FOUND);
    }

    @ExceptionHandler(value= { NoStockDataException.class })
    protected ResponseEntity<ErrorResponse> handleNoStockException(){
        return ErrorResponse.createResponseEntity(ErrorEnum.DATA_NOT_FOUND);
    }

}
