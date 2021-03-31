package com.sparta.alex.exceptions;

public class ArrayTooSmallException extends Exception {
    public ArrayTooSmallException(String errorMessage) {
        super(errorMessage);
    }
}