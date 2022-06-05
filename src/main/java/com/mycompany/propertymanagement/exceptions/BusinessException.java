package com.mycompany.propertymanagement.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException
{

    private List<ErrorModel> final errors;

    public BusinessException(List<ErrorModel> errors)
    {
        this.errors = errors;
    }





}
