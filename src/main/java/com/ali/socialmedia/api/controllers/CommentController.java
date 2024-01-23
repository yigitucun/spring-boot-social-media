package com.ali.socialmedia.api.controllers;

import com.ali.socialmedia.business.abstracts.CommentService;
import com.ali.socialmedia.core.dto.requests.AddCommentRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody AddCommentRequest request){
        return new ResponseEntity<>(this.commentService.add(request), HttpStatus.CREATED);
    }
}
