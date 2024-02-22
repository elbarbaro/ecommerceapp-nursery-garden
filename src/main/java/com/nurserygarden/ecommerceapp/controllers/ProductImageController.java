package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.controllers.responses.ProductImageResponse;
import com.nurserygarden.ecommerceapp.services.ProductImageService;
import com.nurserygarden.ecommerceapp.validators.ValidFile;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Validated
@RestController
@RequestMapping("/images")
public class ProductImageController {

    private ProductImageService productImageService;


    public ProductImageController(ProductImageService productImageService) {
        this.productImageService = productImageService;

    }

    @PostMapping(path = "/products/{id}/images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ProductImageResponse> saveImage(@ValidFile @RequestBody @RequestPart @RequestParam("image") MultipartFile document, @PathVariable("id") Long id) {

        ProductImageResponse fullResponse = productImageService.create(document, id);

        return ResponseEntity.ok(fullResponse);
    }

}