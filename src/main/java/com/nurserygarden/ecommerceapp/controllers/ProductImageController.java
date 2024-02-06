package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.controllers.responses.ProductImageResponse;
import com.nurserygarden.ecommerceapp.filestore.FileStoreServiceImpl;
import com.nurserygarden.ecommerceapp.services.ProductImageServiceImpl;
import com.nurserygarden.ecommerceapp.validators.ValidFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Validated
@RestController
@RequestMapping("/images")
public class ProductImageController {

    private final static Logger log = LoggerFactory.getLogger(ProductImageController.class);

    private FileStoreServiceImpl fileStoreService;
    private ProductImageServiceImpl productImageServiceImpl;


    public ProductImageController(FileStoreServiceImpl fileStoreService, ProductImageServiceImpl productImageServiceImpl) {

        this.fileStoreService = fileStoreService;
        this.productImageServiceImpl = productImageServiceImpl;

    }

    @PostMapping(path = "/products/{id}/images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ProductImageResponse> saveImage(@ValidFile @RequestPart @RequestParam("image") MultipartFile document, @PathVariable("id") Long id) throws Exception {

        ProductImageResponse response = fileStoreService.uploadMultipartFileS3(document, id);

        ProductImageResponse fullResponse = productImageServiceImpl.create(response.getUrl(), id);


        return ResponseEntity.ok(fullResponse);
    }

}