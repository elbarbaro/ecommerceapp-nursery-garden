package com.nurserygarden.ecommerceapp.repositories.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private java.lang.Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "large_name")
    private String largeName;
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    //@Enumerated(EnumType.ORDINAL)
    //@Column(columnDefinition = status_enum)
    //private Status status;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt = OffsetDateTime.now();


    @Column(name = "deleted_at")
    private OffsetDateTime deletededAt;

    public Product() {
    }

    public Product(Long id, String name, String largeName, String description, Integer quantity, BigDecimal price, String color, Category category, OffsetDateTime createdAt, OffsetDateTime updatedAt, OffsetDateTime deletededAt) {
        this.id = id;
        this.name = name;
        this.largeName = largeName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.color = color;
        this.category = category;
        //this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletededAt = deletededAt;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    /*
        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    */
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OffsetDateTime getDeletededAt() {
        return deletededAt;
    }

    public void setDeletededAt(OffsetDateTime deletededAt) {
        this.deletededAt = deletededAt;
    }
}
