package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.ProductDto;
import com.nurserygarden.ecommerceapp.controllers.responses.ProductResponse;
import com.nurserygarden.ecommerceapp.exceptions.CategoryNotFoundException;
import com.nurserygarden.ecommerceapp.exceptions.ProductNotFoundException;
import com.nurserygarden.ecommerceapp.repositories.CategoryRepository;
import com.nurserygarden.ecommerceapp.repositories.ProductRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.Category;
import com.nurserygarden.ecommerceapp.repositories.entities.Product;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<ProductResponse> get() {

        Iterable<Product> findAllIterable = productRepository.findAll();
        return mapToList(findAllIterable);
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        return toProductResponse(product);
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

            Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow( CategoryNotFoundException::new);

            product.setName(productDTO.getName());
            product.setLargeName(productDTO.getLargeName());
            product.setDescription(productDTO.getDescription());
            product.setQuantity(productDTO.getQuantity());
            product.setPrice(productDTO.getPrice());
            product.setColor(productDTO.getColor());
            product.setCategory(category);
            product.setStatus(Status.ACTIVE);

            Product productCreated = productRepository.save(product);
            return toProductResponse(productCreated);



    }

    @Override
    public ProductResponse update(ProductDto productDto, Long id) {
        Product productDb = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow(CategoryNotFoundException::new);

        productDb.setName(productDto.getName());
        productDb.setLargeName(productDto.getLargeName());
        productDb.setDescription(productDto.getDescription());
        productDb.setQuantity(productDto.getQuantity());
        productDb.setPrice(productDto.getPrice());
        productDb.setColor(productDto.getColor());
        productDb.setCategory(category);
        productDb.setUpdatedAt(OffsetDateTime.now());

        Product productUpdated = productRepository.save(productDb);
        return toProductResponse(productUpdated);
    }

    @Override
    public void deleteById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        product.setStatus(Status.INACTIVE);
        product.setDeletededAt(OffsetDateTime.now());

        productRepository.save(product);

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
