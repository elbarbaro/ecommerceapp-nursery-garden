package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.ProductDto;
import com.nurserygarden.ecommerceapp.controllers.responses.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<ProductResponse> get();

    ProductResponse getById(Long id) ;

    ProductResponse create(ProductDto product);

    ProductResponse update(ProductDto productDto, Long id);

    void deleteById(Long id);

}

