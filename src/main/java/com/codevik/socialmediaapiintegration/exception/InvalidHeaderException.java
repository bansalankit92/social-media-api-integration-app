package com.codevik.socialmediaapiintegration.exception;

public class InvalidHeaderException extends RuntimeException {
    public InvalidHeaderException() {
    }

    public InvalidHeaderException(String message) {
        super(message);
    }
}
