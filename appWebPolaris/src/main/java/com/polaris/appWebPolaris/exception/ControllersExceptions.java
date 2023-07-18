package com.polaris.appWebPolaris.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllersExceptions {

    @ExceptionHandler({CustomerExistsException.class, CustomerNotExistException.class, PasswordIncorrectException.class, EmailValidationException.class})
    public ProblemDetail badRequestException(RuntimeException runtimeException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
    }
}
