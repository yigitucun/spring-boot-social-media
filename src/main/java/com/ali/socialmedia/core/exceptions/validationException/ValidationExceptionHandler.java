package com.ali.socialmedia.core.exceptions.validationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ValidationExceptionDetails> handleValidationException(MethodArgumentNotValidException e){
        ValidationExceptionDetails details = new ValidationExceptionDetails();
        details.setValidationErrors(new HashMap<>());
        for (FieldError error:e.getBindingResult().getFieldErrors()){
            details.getValidationErrors().put(error.getField(),error.getDefaultMessage());
        }
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);

    }

}
