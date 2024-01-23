package com.ali.socialmedia.core.dto.requests;


public class AddCommentRequest {
    private String comment;
    private int userId;
    private int postId;
    public AddCommentRequest() {
    }
    public AddCommentRequest(String comment, int userId, int postId) {
        this.comment = comment;
        this.userId = userId;
        this.postId = postId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
