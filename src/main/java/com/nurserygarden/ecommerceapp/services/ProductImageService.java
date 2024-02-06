package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.responses.ProductImageResponse;

public interface ProductImageService {

    ProductImageResponse create(String imageUrl, Long productId);
}
