package com.debmalya.financial_data_processing.Exceptions.dtos;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private String error;
    private int status;
    private String message;
    private Instant timestamp;
}
