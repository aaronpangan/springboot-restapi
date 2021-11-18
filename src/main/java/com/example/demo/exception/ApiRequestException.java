package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ApiRequestException extends ResponseStatusException {

    public ApiRequestException(HttpStatus status, String message) {
        super(status, message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
