package com.orderflow.exception;


import jakarta.validation.ValidationException;

public class BadRequestException extends ValidationException {

    private static final long serialVersionUID = -972126063078614274L;

    public BadRequestException() {}

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }

    public BadRequestException(Exception e) {
        super(e);
    }
}

