package com.ali.socialmedia.core.exceptions.validationException;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class ValidationExceptionDetails {
    private HashMap<String,String> validationErrors;
    private final long timestamp = System.currentTimeMillis();
    private final int statusCode = HttpStatus.BAD_REQUEST.value();

    public ValidationExceptionDetails() {
    }

    public HashMap<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(HashMap<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
