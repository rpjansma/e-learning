package com.elearning.web.exception.exceptions;


public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg) {
        super(msg);
    }

    private BadRequestException() {
    }
}
