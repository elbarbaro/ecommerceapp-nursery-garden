package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.CategoryDto;
import com.nurserygarden.ecommerceapp.controllers.responses.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryDto category);

    List<CategoryResponse> findAll();
}
