package com.debmalya.financial_data_processing.finance.Category;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,UUID>{
    Boolean existsByName(String name);
}
