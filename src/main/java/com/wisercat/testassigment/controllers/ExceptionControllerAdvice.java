package com.wisercat.testassigment.controllers;

import com.wisercat.testassigment.exceptions.FilterNotFoundException;
import com.wisercat.testassigment.exceptions.NotYetImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ExceptionControllerAdvice {
    @ResponseBody
    @ExceptionHandler(FilterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String filterNotFoundHandler(FilterNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NotYetImplementedException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    String notYetImplementedHandler(NotYetImplementedException exception) {
        return exception.getMessage();
    }
}