package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.responses.ProductImageResponse;
import com.nurserygarden.ecommerceapp.exceptions.FileStoreBadGateWayException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductImageService {

    List<ProductImageResponse> create(MultipartFile[] file, Long productId) throws FileStoreBadGateWayException;
}
