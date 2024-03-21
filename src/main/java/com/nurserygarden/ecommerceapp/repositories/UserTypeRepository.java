package com.nurserygarden.ecommerceapp.repositories;

import com.nurserygarden.ecommerceapp.repositories.entities.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Long> {

}
