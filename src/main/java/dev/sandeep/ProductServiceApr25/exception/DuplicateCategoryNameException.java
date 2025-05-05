package dev.sandeep.ProductServiceApr25.exception;

public class DuplicateCategoryNameException extends RuntimeException{
    public DuplicateCategoryNameException() {
    }

    public DuplicateCategoryNameException(String message) {
        super(message);
    }
}
