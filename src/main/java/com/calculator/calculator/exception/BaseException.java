package com.calculator.calculator.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends Exception{

    private final HttpStatus httpStatus;

    private final String errorCode;

    public BaseException(){
        super("Internal Server Error");
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = "500";
    }

    public BaseException(String errorMessage, HttpStatus httpStatus, String errorCode) {
        super(errorMessage);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        this.errorCode = "500";
    }

    public BaseException(HttpStatus httpStatus, String errorCode) {
        super("Bad Request");
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }
}
