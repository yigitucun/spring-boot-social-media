package com.ali.socialmedia.entities.concretes;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity implements Serializable {
    private String comment;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
