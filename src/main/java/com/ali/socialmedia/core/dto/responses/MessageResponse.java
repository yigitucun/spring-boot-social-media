package com.ali.socialmedia.core.dto.responses;

public class MessageResponse {
    private String message;
    private final long timestamp = System.currentTimeMillis();
    private int statusCode;

    public long getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
