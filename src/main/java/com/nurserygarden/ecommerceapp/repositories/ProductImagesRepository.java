package com.nurserygarden.ecommerceapp.repositories;

import com.nurserygarden.ecommerceapp.repositories.entities.ProductImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImagesRepository extends CrudRepository <ProductImage, Long> {
    
}
