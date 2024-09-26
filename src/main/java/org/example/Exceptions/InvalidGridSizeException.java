package org.example.Exceptions;

public class InvalidGridSizeException extends RuntimeException {
    public InvalidGridSizeException(String message) {
        super(message);
    }
}
