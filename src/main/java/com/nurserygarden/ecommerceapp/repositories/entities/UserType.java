package com.nurserygarden.ecommerceapp.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "profile_image_url", nullable = false)
    private String profileImageUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    @Column(name = "deleted_at")
    private OffsetDateTime deletededAt;
}
