package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.CategoryDto;
import com.nurserygarden.ecommerceapp.controllers.responses.CategoryResponse;
import com.nurserygarden.ecommerceapp.repositories.entities.Category;

public interface CategoryService {
    CategoryResponse create(CategoryDto category);

    Category findById(Long id);
}
