package com.nurserygarden.ecommerceapp.controllers.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;

public class ProductImageDto {

    @JsonProperty("image_url")
    String url;
    @JsonProperty("status")
    Status status;

    public ProductImageDto() {
    }

    public ProductImageDto(String url, Status status) {
        this.url = url;
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
