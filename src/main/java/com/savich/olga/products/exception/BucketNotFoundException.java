package com.savich.olga.products.exception;

public class BucketNotFoundException extends RuntimeException{
    public BucketNotFoundException(String message) {
        super(message);
    }

}
