package com.debmalya.financial_data_processing.finance.Category.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateCategoryResponse {
    private UUID id;
    private String name;
    private Boolean isActive;
}
