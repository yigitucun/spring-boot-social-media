package com.ali.socialmedia.core.dto.requests;

import jakarta.validation.constraints.NotBlank;

public class UpdatePostRequest {
    private int id;
    @NotBlank(message = "Title required")
    private String title;
    @NotBlank(message = "Description required")
    private String description;
    private int userId;
    private String postPhotoUrl;

    public UpdatePostRequest() {
    }

    public UpdatePostRequest(int id, String title, String description, int userId, String postPhotoUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.postPhotoUrl = postPhotoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostPhotoUrl() {
        return postPhotoUrl;
    }

    public void setPostPhotoUrl(String postPhotoUrl) {
        this.postPhotoUrl = postPhotoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

