package com.nurserygarden.ecommerceapp.repositories;

import com.nurserygarden.ecommerceapp.repositories.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
