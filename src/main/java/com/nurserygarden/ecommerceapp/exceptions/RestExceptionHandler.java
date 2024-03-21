package com.nurserygarden.ecommerceapp.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(HttpServletRequest req, ProductNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
        response.setMessage("Product not found" + req.getRequestURI());
        return buildResponseEntity(response);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Object> handleCategoryNotFoundException(HttpServletRequest req, CategoryNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
        response.setMessage("Category not found " + req.getRequestURI());
        return buildResponseEntity(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(HttpServletRequest req, ConstraintViolationException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST);
        response.setMessage("File not valid, error: " + ex.getMessage());
        return buildResponseEntity(response);
    }

    @ExceptionHandler(FileStoreBadGateWayException.class)
    public ResponseEntity<Object> handleFileStoreBadGateWayException(HttpServletRequest req, FileStoreBadGateWayException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_GATEWAY);
        response.setMessage(ex.getMessage());
        return buildResponseEntity(response);
    }

    @ExceptionHandler(UserTypeNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(HttpServletRequest req, UserTypeNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST);
        response.setMessage("UserType not found " + req.getRequestURI());
        return buildResponseEntity(response);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }
}