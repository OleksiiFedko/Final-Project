package com.hotel.domain.exceptions;

public class TechnicalException extends Exception {

    public TechnicalException() {
        super();
    }

    public TechnicalException(String message) {
        super(message);
    }
}
