package com.ali.socialmedia.core.exceptions;

public class ExceptionDetails {
    private String message;
    private final long timestamp = System.currentTimeMillis();
    private int statusCode;
    public ExceptionDetails() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
