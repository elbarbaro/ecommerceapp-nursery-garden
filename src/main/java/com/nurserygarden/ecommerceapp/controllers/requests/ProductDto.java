package com.nurserygarden.ecommerceapp.controllers.requests;

import java.math.BigDecimal;

public class ProductDto {
    private String name;
    private String largeName;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private String color;
    private Long categoryId;

    public ProductDto() {
    }

    public ProductDto(String name, String largeName, String description, Integer quantity, BigDecimal price, String color, Long categoryId) {
        this.name = name;
        this.largeName = largeName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.color = color;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLargeName() {
        return largeName;
    }

    public void setLargeName(String largeName) {
        this.largeName = largeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
