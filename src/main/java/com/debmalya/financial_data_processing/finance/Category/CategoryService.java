package com.debmalya.financial_data_processing.finance.Category;

import com.debmalya.financial_data_processing.finance.Category.dtos.*;
import com.debmalya.financial_data_processing.Exceptions.CategoryAlreadyExistsException;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(CreateCategoryRequest req){
        if(categoryRepository.existsByName(req.getName())){
            throw new CategoryAlreadyExistsException(req.getName());
        }
        Category category = new Category();
        category.setName(req.getName());
        category.setIsActive(true);
        categoryRepository.save(category);
        return category;
    }

    public Category updateCategory(UUID id, UpdateCategoryRequest req){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Financial category not found"));
        if(req.getName()!=null) category.setName(req.getName());
        if(req.getIsActive()!=null) category.setIsActive(req.getIsActive());
        categoryRepository.save(category);
        return category;
    }
}
