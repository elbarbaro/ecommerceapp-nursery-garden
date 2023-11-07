package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.CategoryDto;
import com.nurserygarden.ecommerceapp.controllers.responses.CategoryResponse;
import com.nurserygarden.ecommerceapp.repositories.entities.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryDto category);

    List<CategoryResponse> findAll();

    Category findById(Long id);
}
