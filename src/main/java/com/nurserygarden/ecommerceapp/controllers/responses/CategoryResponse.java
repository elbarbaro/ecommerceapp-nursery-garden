package com.nurserygarden.ecommerceapp.controllers.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class CategoryResponse {

    private Long id;
    private String name;
    private String description;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private OffsetDateTime createAt;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private OffsetDateTime updatedAt;
    private OffsetDateTime deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(OffsetDateTime createAt) {
        this.createAt = createAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OffsetDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(OffsetDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
