package com.example.demo.exception;

import java.time.ZonedDateTime;

public class ExceptionResponse {

    private ZonedDateTime timestamp;
    private String message;
    private String details;

    public ExceptionResponse(ZonedDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    // @Override
    // public synchronized Throwable fillInStackTrace() {
    // return this;
    // }

}
