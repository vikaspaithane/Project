package com.clothshop.management.Exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message){
        super(message);
    }
}
