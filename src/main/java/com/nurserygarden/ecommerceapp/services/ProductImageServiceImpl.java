package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.responses.ProductImageResponse;
import com.nurserygarden.ecommerceapp.exceptions.ProductNotFoundException;
import com.nurserygarden.ecommerceapp.repositories.ProductImagesRepository;
import com.nurserygarden.ecommerceapp.repositories.ProductRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.Product;
import com.nurserygarden.ecommerceapp.repositories.entities.ProductImages;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private ProductImagesRepository productImagesRepository;

    private ProductRepository productRepository;

    public ProductImageServiceImpl(ProductImagesRepository productImagesRepository, ProductRepository productRepository) {
        this.productImagesRepository = productImagesRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductImageResponse create(String imageUrl, Long productId) {

        ProductImages productImage = new ProductImages();

        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        productImage.setProductId(product);
        productImage.setImageUrl(imageUrl);
        productImage.setStatus(Status.ACTIVE);

        ProductImages productImagesCreated = productImagesRepository.save(productImage);


        return productImagesResponse(productImagesCreated);
    }

    private ProductImageResponse productImagesResponse(ProductImages productImagesCreated) {

        ProductImageResponse response = new ProductImageResponse();

        response.setId(productImagesCreated.getId());
        response.setUrl(productImagesCreated.getImageUrl());
        response.setProductId(productImagesCreated.getProductId().getId());
        response.setStatus(productImagesCreated.getStatus());
        response.setCreatedAt(productImagesCreated.getCreatedAt());
        response.setUpdatedAt(productImagesCreated.getUpdatedAt());

        return response;
    }
}

