package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.ProductDto;
import com.nurserygarden.ecommerceapp.controllers.responses.ProductResponse;
import com.nurserygarden.ecommerceapp.repositories.ProductRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getProducts() {
        return (List <Product>) productRepository.findAll();
    }

    @Override
    public ProductResponse create(ProductDto productDTO) {
        Product product = new Product();

        product.setName(productDTO.getName());
        product.setLargeName(productDTO.getLargeName());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        product.setColor(productDTO.getColor());
        product.setCategoryId(productDTO.getCategoryId());

        Product productCreated = productRepository.save(product);
        return toProductResponse(productCreated);
    }

    private ProductResponse toProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();

        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setLargeName(product.getLargeName());
        productResponse.setDescription(product.getDescription());
        productResponse.setQuantity(product.getQuantity());
        productResponse.setPrice(product.getPrice());
        productResponse.setColor(product.getColor());
        //productResponse.setCategoryName(product.getCategoryId());
        productResponse.setCreated_at(product.getCreatedAt());
        productResponse.setUpdated_at(product.getUpdatedAt());

        return productResponse;
    }
}
