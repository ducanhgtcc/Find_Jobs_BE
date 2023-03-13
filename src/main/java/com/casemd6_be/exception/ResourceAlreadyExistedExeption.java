package com.casemd6_be.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistedExeption extends RuntimeException{
    public ResourceAlreadyExistedExeption() {
    }

    public ResourceAlreadyExistedExeption(String message) {
        super(message);
    }

    public ResourceAlreadyExistedExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAlreadyExistedExeption(Throwable cause) {
        super(cause);
    }

    public ResourceAlreadyExistedExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
