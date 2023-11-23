package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.ProductDto;
import com.nurserygarden.ecommerceapp.controllers.responses.ProductResponse;
import com.nurserygarden.ecommerceapp.repositories.CategoryRepository;
import com.nurserygarden.ecommerceapp.repositories.ProductRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.Category;
import com.nurserygarden.ecommerceapp.repositories.entities.Product;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<ProductResponse> get() {

        Iterable<Product> findAllIterable = productRepository.findAll();
        return mapToList(findAllIterable);
    }

    private List<ProductResponse> mapToList(Iterable<Product> iterable) {
        List<ProductResponse> listOfProductResponse = new ArrayList<>();
        for (Product product : iterable) {
            listOfProductResponse.add(toProductResponse(product));
        }
        return listOfProductResponse;
    }


    @Override
    public ProductResponse create(ProductDto productDTO) {
        Product product = new Product();
        try {
            Optional<Category> category = categoryRepository.findById(productDTO.getCategoryId());

            product.setName(productDTO.getName());
            product.setLargeName(productDTO.getLargeName());
            product.setDescription(productDTO.getDescription());
            product.setQuantity(productDTO.getQuantity());
            product.setPrice(productDTO.getPrice());
            product.setColor(productDTO.getColor());
            product.setCategory(category.get());
            product.setStatus(Status.ACTIVE);

            Product productCreated = productRepository.save(product);
            return toProductResponse(productCreated);
        } catch (Exception e) {
            System.err.println("Product not created");
        }
        return null;
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
        productResponse.setCategoryName(product.getCategory().getName());
        productResponse.setStatus(product.getStatus());
        productResponse.setCreatedAt(product.getCreatedAt());
        productResponse.setUpdatedAt(product.getUpdatedAt());


        return productResponse;
    }
}
