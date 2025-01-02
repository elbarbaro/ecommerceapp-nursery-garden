package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.UserDto;
import com.nurserygarden.ecommerceapp.controllers.responses.UserResponse;
import com.nurserygarden.ecommerceapp.repositories.UserRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.Status;
import com.nurserygarden.ecommerceapp.controllers.responses.UserTypeValue;
import com.nurserygarden.ecommerceapp.repositories.entities.User;
import com.nurserygarden.ecommerceapp.repositories.entities.UserType;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserTypeServiceImpl userTypeServiceImpl;

    public UserServiceImpl(UserRepository userRepository, UserTypeServiceImpl userTypeServiceImpl) {
        this.userRepository = userRepository;
        this.userTypeServiceImpl = userTypeServiceImpl;
    }

    @Override
    public UserResponse create(UserDto userDto) {

        UserType userType = userTypeServiceImpl.findUserTypeById(userDto.getUserTypeId());
        User user = new User();

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

    private UserResponse toUserResponse(User user) {

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setUserTypeValue(UserTypeValue.valueOf(user.getUserType().getName()));
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
