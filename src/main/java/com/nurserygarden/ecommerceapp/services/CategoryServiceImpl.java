package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.CategoryDto;
import com.nurserygarden.ecommerceapp.controllers.responses.CategoryResponse;
import com.nurserygarden.ecommerceapp.exceptions.CategoryNotFoundException;
import com.nurserygarden.ecommerceapp.repositories.CategoryRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        Category categoryCreated = categoryRepository.save(category);

        return toCategoryResponse(categoryCreated);
    }

    @Override
    public Category findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);

        return category;
    }

    @Override
    public List<CategoryResponse> findAll() {
        Iterable<Category> categories = categoryRepository.findAll();
        return buildCategoryResponseFromStream(categories);
    }

    private List<CategoryResponse> buildCategoryResponseList(Iterable<Category> categories) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for(Category category: categories) {
            categoryResponses.add(toCategoryResponse(category));
        }
        return categoryResponses;
    }

    private List<CategoryResponse> buildCategoryResponseFromStream(Iterable<Category> categories) {
        return StreamSupport
                .stream(categories.spliterator(), false)
                .map(this::toCategoryResponse).collect(Collectors.toList());
    }

    private CategoryResponse toCategoryResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setDescription(category.getDescription());
        response.setCreateAt(category.getCreatedAt());
        response.setUpdatedAt(category.getUpdatedAt());

        return response;
    }
}
