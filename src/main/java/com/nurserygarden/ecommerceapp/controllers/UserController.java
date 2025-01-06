package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.controllers.requests.UserDto;
import com.nurserygarden.ecommerceapp.controllers.responses.UserResponse;
import com.nurserygarden.ecommerceapp.services.UserService;
import com.nurserygarden.ecommerceapp.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/users")
public class UserController {

    private UserService userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDto user) {

        UserResponse response = userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
