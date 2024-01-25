package com.nurserygarden.ecommerceapp.controllers.requests;

public class ImageDto {

    String url;

    public ImageDto() {
    }

    public ImageDto(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
