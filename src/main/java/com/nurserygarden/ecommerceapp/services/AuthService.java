package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.controllers.requests.TokenDto;
import com.nurserygarden.ecommerceapp.controllers.requests.TokenRequest;

public interface AuthService {
    TokenDto authValidation(TokenRequest request);
}
