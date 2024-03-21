package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.controllers.requests.UserDto;
import com.nurserygarden.ecommerceapp.controllers.responses.UserResponse;
import com.nurserygarden.ecommerceapp.services.UserService;
import com.nurserygarden.ecommerceapp.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @PostMapping(path = "/users")
    public HttpStatus createUser(@RequestBody UserDto user) {

        UserResponse response = userService.create(user);

        return ResponseEntity.ok(response).getStatusCode();

    }
}
