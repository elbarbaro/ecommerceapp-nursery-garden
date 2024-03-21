package com.nurserygarden.ecommerceapp.controllers.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserResponse {
    private Long id;
    private String email;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("profile_image_url")
    private String profileImageUrl;
    private Status status;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;
    @JsonProperty("deleted_at")
    private OffsetDateTime deletedAt;
}
