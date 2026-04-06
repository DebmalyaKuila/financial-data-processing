package com.debmalya.financial_data_processing.Exceptions;

public class CategoryAlreadyExistsException extends RuntimeException{
    public CategoryAlreadyExistsException(String name){
        super("Category already exists");
    }
}
