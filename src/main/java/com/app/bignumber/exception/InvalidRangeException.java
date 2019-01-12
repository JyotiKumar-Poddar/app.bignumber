package com.app.bignumber.exception;

/**
 * Exception to handle invalid range input.
 */
public class InvalidRangeException extends RuntimeException {
    public InvalidRangeException(String message) {
        super(message);
    }
}
