package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.responses.ProductImageResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProductImageService {

    ProductImageResponse create(MultipartFile file, Long productId);
}
