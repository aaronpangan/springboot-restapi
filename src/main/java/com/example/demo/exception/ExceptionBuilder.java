package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
@RestController
public class ExceptionBuilder extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ZonedDateTime.now(ZoneId.of("Z")), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    // Will intercept the ApiRequest Exception
    @ExceptionHandler(ApiRequestException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ApiRequestException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(ZonedDateTime.now(ZoneId.of("Z")), ex.getMessage(),
                request.getDescription(false));
        // First Argument is what returns to the user, and the 2nd one is the status
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(ZonedDateTime.now(ZoneId.of("Z")),
                "Validation Failed", ex.getBindingResult().toString());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
