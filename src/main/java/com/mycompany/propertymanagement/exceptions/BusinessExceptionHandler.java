package com.mycompany.propertymanagement.exceptions;

import ch.qos.logback.core.CoreConstants;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ControllerAdvice
public class BusinessExceptionHandler {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> fieldValidation(MethodArgumentNotValidException mnv)
    {
        List<ErrorModel> errList =  new ArrayList<>();

        List<FieldError> fieldError = mnv.getBindingResult().getFieldErrors();

        ErrorModel errModel = null;

        for(FieldError fe:fieldError)
        {
            logger.info("Inside Field Validation: level - info  {} {}", fe.getField(), fe.getDefaultMessage());
            //logger.debug("Inside Field Validation: level - debug {} {}", fe.getField(), fe.getDefaultMessage());
            logger.warning("Inside Field Validation: level - Warn  {} {}", fe.getField(), fe.getDefaultMessage());
            //logger.error("Inside Field Validation: level - error  {} {}", fe.getField(), fe.getDefaultMessage());
            errModel = new ErrorModel();

           errModel.setError(fe.getField());
           errModel.setMessage(fe.getDefaultMessage());

           errList.add(errModel);


        }

        return new ResponseEntity<List<ErrorModel>>(errList, HttpStatus.EXPECTATION_FAILED);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> businessExceptionHandler(BusinessException be)
    {

        for(ErrorModel errModel : be.getErrors())
        {
            logger.info("Businees Exception is thrown : {} {}", errModel.getError(), errModel.getMessage() );
            logger.warning("Businees Exception is thrown : {} {}", errModel.getError(), errModel.getMessage() );
            logger.error("Businees Exception is thrown : {} {}", errModel.getError(), errModel.getMessage() );
        }


        System.out.println("Exception Has Thrown");
        return new ResponseEntity<>(be.getErrors(),HttpStatus.BAD_REQUEST );
    }
}
