package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.controllers.requests.ProductDto;
import com.nurserygarden.ecommerceapp.controllers.responses.ProductResponse;
import com.nurserygarden.ecommerceapp.services.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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


    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable("id") Long id){

        return productService.getById(id);

    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductDto product) {

        ProductResponse productCreated = productService.create(product);

        return productCreated;
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@RequestBody ProductDto product, @PathVariable("id") Long id) {
        return productService.update(product, id);
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id,  HttpServletResponse response){

         productService.deleteById(id);
         response.setStatus(HttpStatus.NO_CONTENT.value());

    }
}
