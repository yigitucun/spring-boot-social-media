package com.ali.socialmedia.core.exceptions.noResourceFoundException;

import com.ali.socialmedia.core.exceptions.ExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class NoResourceFoundExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionDetails> handleNoResourceFoundException(NoResourceFoundException exception){
        ExceptionDetails details = new ExceptionDetails();
        details.setMessage("Sayfa bulunamadı");
        details.setStatusCode(404);
        return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
    }

}
