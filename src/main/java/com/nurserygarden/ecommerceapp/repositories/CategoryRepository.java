package com.nurserygarden.ecommerceapp.repositories;

import com.nurserygarden.ecommerceapp.repositories.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
