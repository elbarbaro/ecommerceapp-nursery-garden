package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.ProductDto;
import com.nurserygarden.ecommerceapp.controllers.responses.ProductResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<ProductResponse> get();

    ProductResponse getById(Long id) throws ChangeSetPersister.NotFoundException;

    ProductResponse create(ProductDto product);

    ProductResponse update(ProductDto productDto, Long id);

}

