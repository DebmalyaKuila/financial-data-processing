package com.debmalya.financial_data_processing.finance.Category;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.debmalya.financial_data_processing.finance.Category.dtos.CreateCategoryRequest;
import com.debmalya.financial_data_processing.finance.Category.dtos.CreateCategoryResponse;
import com.debmalya.financial_data_processing.finance.Category.dtos.UpdateCategoryRequest;
import com.debmalya.financial_data_processing.finance.Category.dtos.UpdateCategoryResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/finance/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;
    
    @PostMapping("/register")
    public ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest createCategoryRequest){
        Category category = categoryService.createCategory(createCategoryRequest);
        CreateCategoryResponse response = new CreateCategoryResponse(
            category.getId(),
            category.getName(),
            category.getIsActive(),
            category.getCreatedAt()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable UUID id, @RequestBody UpdateCategoryRequest updateCategoryRequest){
        Category updatedCategory = categoryService.updateCategory(id, updateCategoryRequest);
        UpdateCategoryResponse response = new UpdateCategoryResponse(
            id, 
            updatedCategory.getName(), 
            updatedCategory.getIsActive()
        );
        return ResponseEntity.ok(response);
    }

}
