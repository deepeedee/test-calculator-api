package com.calculator.calculator.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidOperationException extends BaseException{

    public InvalidOperationException(){
        super("Invalid Operation",HttpStatus.BAD_REQUEST,"500");
    }

}
