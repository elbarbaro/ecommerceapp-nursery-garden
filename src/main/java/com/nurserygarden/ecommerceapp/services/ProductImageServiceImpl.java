package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.responses.ProductImageResponse;
import com.nurserygarden.ecommerceapp.exceptions.ProductNotFoundException;
import com.nurserygarden.ecommerceapp.filestore.FileStoreServiceImpl;
import com.nurserygarden.ecommerceapp.repositories.ProductImagesRepository;
import com.nurserygarden.ecommerceapp.repositories.ProductRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.Product;
import com.nurserygarden.ecommerceapp.repositories.entities.ProductImage;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private ProductImagesRepository productImagesRepository;

    private ProductRepository productRepository;

    private FileStoreServiceImpl fileStoreService;

    public ProductImageServiceImpl(FileStoreServiceImpl fileStoreService, ProductImagesRepository productImagesRepository, ProductRepository productRepository) {
        this.productImagesRepository = productImagesRepository;
        this.productRepository = productRepository;
        this.fileStoreService = fileStoreService;

    }

    @Override
    public List<ProductImageResponse> create(MultipartFile[] files, Long productId) {

        ProductImage productImage;
        ProductImage productImageCreated;
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);


        ArrayList<ProductImageResponse> productImageList = new ArrayList<>();
        if (files.length > 0) {
            for (MultipartFile file : files) {
                productImage = new ProductImage();

                String imageUrl = fileStoreService.uploadMultipartFileS3(file, productId);

                productImage.setProductId(product);
                productImage.setImageUrl(imageUrl);
                productImage.setStatus(Status.ACTIVE);
                productImage.getId();

                productImageCreated = productImagesRepository.save(productImage);
                productImageList.add(productImagesResponse(productImageCreated));

            }
        }
        return productImageList;
    }

    private ProductImageResponse productImagesResponse(ProductImage productImageCreated) {

        ProductImageResponse response = new ProductImageResponse();

        response.setId(productImageCreated.getId());
        response.setUrl(productImageCreated.getImageUrl());
        response.setProductId(productImageCreated.getProductId().getId());
        response.setStatus(productImageCreated.getStatus());
        response.setCreatedAt(productImageCreated.getCreatedAt());
        response.setUpdatedAt(productImageCreated.getUpdatedAt());

        return response;
    }
}
