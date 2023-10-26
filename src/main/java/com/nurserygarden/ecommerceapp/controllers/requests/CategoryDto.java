package com.nurserygarden.ecommerceapp.controllers.requests;

public class CategoryDto {

    private String name;
    private String description;

    public CategoryDto() {}

    public CategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
