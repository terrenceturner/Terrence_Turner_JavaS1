package com.company.weatherwebservice.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors.VndError> numberFormatException (NumberFormatException e, WebRequest request) {
        VndErrors.VndError error = new VndErrors.VndError(e.toString(), "Invalid zipcode entered");

        return new ResponseEntity<VndErrors.VndError>(error, HttpStatus.BAD_REQUEST);

    }


}

