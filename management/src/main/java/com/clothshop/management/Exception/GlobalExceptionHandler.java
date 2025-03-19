package com.clothshop.management.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCustomerNotFound(CustomerNotFoundException ex) {
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleSupplierNotFound(SupplierNotFoundException ex){
        return buildErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleProductNotFound(ProductNotFoundException ex){
        return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }



    private ResponseEntity<Map<String, Object>> buildErrorResponse(String message, HttpStatus status) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", status.value());
        errorResponse.put("error", status.getReasonPhrase());
        errorResponse.put("message", message != null ? message : "An unexpected error occurred");
        return new ResponseEntity<>(errorResponse, status);
    }
}
