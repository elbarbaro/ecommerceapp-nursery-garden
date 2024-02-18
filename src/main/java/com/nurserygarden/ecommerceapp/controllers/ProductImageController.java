package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.controllers.responses.ProductImageResponse;
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

    private ProductImageServiceImpl productImageServiceImpl;


    public ProductImageController(ProductImageServiceImpl productImageServiceImpl) {
        this.productImageServiceImpl = productImageServiceImpl;

    }

    @PostMapping(path = "/products/{id}/images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ProductImageResponse> saveImage(@ValidFile @RequestBody @RequestPart @RequestParam("image") MultipartFile document, @PathVariable("id") Long id) {

        ProductImageResponse fullResponse = productImageServiceImpl.create(document, id);

        return ResponseEntity.ok(fullResponse);
    }

}