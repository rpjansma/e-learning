package com.elearning.web.exception.exceptions;


public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String msg) {
        super(msg);
    }

    private InternalServerErrorException() {
    }
}
