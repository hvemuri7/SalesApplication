package com.code.sales.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * This class handles exceptions across the whole application
 */
@ControllerAdvice
public class SalesExceptionHandler {

    // This method handles IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<SalesErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        SalesErrorResponse errorResponse = new SalesErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<SalesErrorResponse> handleNullPointerException(NullPointerException ex, WebRequest request) {
        SalesErrorResponse errorResponse = new SalesErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
