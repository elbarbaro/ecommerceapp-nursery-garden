package com.nurserygarden.ecommerceapp.controllers.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ProductImageResponse {

    private Long id;

    @JsonProperty("product_id")
    private Long productId;

    private String url;
    private Status status;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

}