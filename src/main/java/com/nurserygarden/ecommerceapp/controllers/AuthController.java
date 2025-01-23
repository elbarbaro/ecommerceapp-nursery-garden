package com.nurserygarden.ecommerceapp.controllers;

import com.nurserygarden.ecommerceapp.config.CustomAuthenticationToken;
import com.nurserygarden.ecommerceapp.config.JwtUtil;
import com.nurserygarden.ecommerceapp.controllers.requests.TokenRequest;
import com.nurserygarden.ecommerceapp.repositories.entities.User;
import com.nurserygarden.ecommerceapp.services.UserDetailsImpl;
import com.nurserygarden.ecommerceapp.services.UserServiceDetailImpl;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserServiceDetailImpl userServiceDetailimpl;

    public AuthController(AuthenticationManager authenticationManager, UserServiceDetailImpl userServiceDetailimpl) {
        this.authenticationManager = authenticationManager;
        this.userServiceDetailimpl =   userServiceDetailimpl;
    }


    @PostMapping("/token")
    public TokenRequest login(@RequestBody TokenRequest request) {
        Authentication authenticationRequest = new CustomAuthenticationToken(null, request.getEmail(),request.getPassword());

        UserDetails user = userServiceDetailimpl.loadUserByUsername(request.getEmail());
        if(user!= null){
            if(request.getEmail()== user.getUsername()&& request.getPassword() == user.getPassword()){

                authenticationManager.authenticate(authenticationRequest);
            }

        }
        return new TokenRequest(request.getEmail(), request.getPassword());

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

