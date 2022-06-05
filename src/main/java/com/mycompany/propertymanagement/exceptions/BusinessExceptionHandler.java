package com.mycompany.propertymanagement.exceptions;

import ch.qos.logback.core.CoreConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handler(BusinessException be)
    {
        System.out.println("Exception Has Thrown");
        return new ResponseEntity<>(be.getErrors(),HttpStatus.BAD_REQUEST );
    }
}
