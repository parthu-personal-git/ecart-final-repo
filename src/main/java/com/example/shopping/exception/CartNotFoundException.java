package com.example.shopping.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(int id){
        super("Couldn't find Cart with id : " + id);
    }
}
