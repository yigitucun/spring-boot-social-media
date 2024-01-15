package com.ali.socialmedia.core.exceptions.businessException;

import com.ali.socialmedia.core.exceptions.ExceptionDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handleBusinessException(BusinessException e){
        ExceptionDetails details = new ExceptionDetails();
        details.setMessage(e.getMessage());
        details.setStatusCode(e.getHttpStatus().value());
        return new ResponseEntity<>(details,e.getHttpStatus());
    }
}
