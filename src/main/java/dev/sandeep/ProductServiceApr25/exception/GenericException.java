package dev.sandeep.ProductServiceApr25.exception;

public class GenericException extends RuntimeException{
    public GenericException() {
    }

    public GenericException(String message) {
        super(message);
    }
}
