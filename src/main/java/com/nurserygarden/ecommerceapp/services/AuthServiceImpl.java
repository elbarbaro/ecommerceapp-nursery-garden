package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.TokenDto;
import com.nurserygarden.ecommerceapp.controllers.requests.TokenRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserServiceDetailImpl userServiceDetailImpl;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserServiceDetailImpl userServiceDetailImpl, AuthenticationManager authenticationManager) {
        this.userServiceDetailImpl = userServiceDetailImpl;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public TokenDto authValidation(TokenRequest request) {

        UsernamePasswordAuthenticationToken authenticationRequest = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        authenticationManager.authenticate(authenticationRequest);
        return new TokenDto("", "", "", request.getEmail());


    }
}
