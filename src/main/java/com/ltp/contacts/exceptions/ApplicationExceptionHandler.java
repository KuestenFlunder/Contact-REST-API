package com.ltp.contacts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ContactNotFoundException.class)
    public ResponseEntity<Object> handleContactNotFoundException(ContactNotFoundException contactNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(contactNotFoundException.getMessage());
        return new ResponseEntity<Object>(errorResponse,HttpStatus.NOT_FOUND);
    };

}
