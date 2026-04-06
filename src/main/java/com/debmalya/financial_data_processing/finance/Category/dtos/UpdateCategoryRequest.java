package com.debmalya.financial_data_processing.finance.Category.dtos;

import lombok.Data;

@Data
public class UpdateCategoryRequest {
    private String name;
    private Boolean isActive;
}
