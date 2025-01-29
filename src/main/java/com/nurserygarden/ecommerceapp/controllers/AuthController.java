package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.controllers.requests.TokenDto;
import com.nurserygarden.ecommerceapp.controllers.requests.TokenRequest;
import com.nurserygarden.ecommerceapp.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/token")
    public ResponseEntity<TokenDto> login(@RequestBody TokenRequest request) {

        TokenDto  token =   authService.authValidation(request);



        return new ResponseEntity<>(token, HttpStatus.OK);
       /* return
        1. Crear un rest controller
        2. Injectar un objeto del tipo AuthenticationManager
        3. Crear método POST para mapear la ruta /token
        4. Crear un AuthenticationRequest (spring) a partir de los datos que se van a usar para la autencación: email, password
        5. Utilizar el objeto injectado (dependecia) authenticationManager y validar el request usando su método authenticate(request)
                6. Procesar datos de resultado regresado cuando es autenticado.

*/
        // Authenticate the user (e.g., using Spring Security's authentication manager)
        // If authentication is successful, generate a JWT
        //   String token = JwtUtil.generateToken(request.getUsername());
        //  return token;
        // }
    }
}

