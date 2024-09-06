package com.orderflow.exception;

import jakarta.persistence.PersistenceException;

public class InternalServerErrorException extends PersistenceException {
    private static final long serialVersionUID = -972126063078614274L;

    public InternalServerErrorException() {}

    public InternalServerErrorException(String message) {

        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {

        super(message, cause);
    }

    public InternalServerErrorException(Throwable cause) {

        super(cause);
    }

    public InternalServerErrorException(Exception e) {

        super(e);
    }

}
