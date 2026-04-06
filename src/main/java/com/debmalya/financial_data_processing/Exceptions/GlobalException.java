package com.debmalya.financial_data_processing.Exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.debmalya.financial_data_processing.Exceptions.dtos.ErrorResponse;

@RestControllerAdvice
public class GlobalException extends Exception{

    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleEmailAlreadyExistsException(EmailAlreadyExistsException err){

        return new ErrorResponse(
            "Conflict", 
            HttpStatus.CONFLICT.value(), 
            err.getMessage(), 
            Instant.now()
        );
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleFinanceCategoryAlreadyExistsException(CategoryAlreadyExistsException err){

        return new ErrorResponse(
            "Conflict", 
            HttpStatus.CONFLICT.value(), 
            err.getMessage(), 
            Instant.now()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneralException(Exception e) {

        return new ErrorResponse(
            "Internal Server Error",
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Something went wrong",
            Instant.now()
        );
    }
}
