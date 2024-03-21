package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.UserDto;
import com.nurserygarden.ecommerceapp.controllers.responses.UserResponse;
import com.nurserygarden.ecommerceapp.exceptions.UserTypeNotFoundException;
import com.nurserygarden.ecommerceapp.repositories.UserRepository;
import com.nurserygarden.ecommerceapp.repositories.UserTypeRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;
import com.nurserygarden.ecommerceapp.repositories.entities.User;
import com.nurserygarden.ecommerceapp.repositories.entities.UserType;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserTypeRepository userTypeRepository;

    public UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserResponse create(UserDto userDto) {
        User user = new User();
        UserType userType = userTypeRepository.findById(userDto.getUserTypeId()).orElseThrow(UserTypeNotFoundException::new);

        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserType(userType);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setProfileImageUrl(userDto.getProfileImageUrl());
        user.setStatus(Status.ACTIVE);

        User userCreated = userRepository.save(user);
        return toUserResponse(userCreated);
    }

    public UserResponse toUserResponse(User user) {

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setUserType(user.getUserType().getName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setProfileImageUrl(user.getProfileImageUrl());
        userResponse.setStatus(user.getStatus());
        userResponse.setCreatedAt(user.getCreatedAt());
        userResponse.setUpdatedAt(user.getUpdatedAt());
        userResponse.setDeletedAt(user.getDeletededAt());

        return userResponse;
    }
}
