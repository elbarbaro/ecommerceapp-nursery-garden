package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.UserDto;
import com.nurserygarden.ecommerceapp.controllers.responses.UserResponse;

public interface UserService {

    UserResponse create(UserDto user);
}
