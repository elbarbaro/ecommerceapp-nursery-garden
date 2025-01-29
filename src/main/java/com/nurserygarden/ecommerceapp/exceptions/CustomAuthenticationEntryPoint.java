package com.nurserygarden.ecommerceapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("APPLICATION/JSON");

        String jsonResponse = "{ \"error\" : \"Not Authenticated\", \"message\" : \"You need to be authenticated to access this resources\" }";

        PrintWriter out = response.getWriter();
        out.write(jsonResponse);
        out.flush();
    }
}
