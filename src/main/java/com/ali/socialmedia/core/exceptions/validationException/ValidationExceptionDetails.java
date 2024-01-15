package com.ali.socialmedia.core.exceptions.validationException;

import java.util.HashMap;

public class ValidationExceptionDetails {
    private HashMap<String,String> validationErrors;
    private final long timestamp = System.currentTimeMillis();
    private final long statusCode = 400;

    public ValidationExceptionDetails() {
    }

    public HashMap<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(HashMap<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

}
