package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.controllers.requests.ProductDto;
import com.nurserygarden.ecommerceapp.controllers.responses.ProductResponse;
import com.nurserygarden.ecommerceapp.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.get();
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDto product) {

        ProductResponse productCreated = productService.create(product);
        if (productCreated != null) {
            return new ResponseEntity<ProductResponse>(productCreated, HttpStatus.CREATED);
        }
        return new ResponseEntity("Product not saved", HttpStatus.NOT_FOUND);
    }
}
