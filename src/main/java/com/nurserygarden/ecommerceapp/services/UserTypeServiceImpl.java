package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.exceptions.UserTypeNotFoundException;
import com.nurserygarden.ecommerceapp.repositories.UserTypeRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.UserType;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private UserTypeRepository userTypeRepository;

    public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserType findUserTypeById(Long id) {
        UserType userType = userTypeRepository.findById(id).orElseThrow(UserTypeNotFoundException::new);

        return userType;
    }
}
