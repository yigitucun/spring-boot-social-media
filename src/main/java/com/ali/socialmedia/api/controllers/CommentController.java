package com.ali.socialmedia.api.controllers;

import com.ali.socialmedia.business.abstracts.CommentService;
import com.ali.socialmedia.core.dto.requests.AddCommentRequest;
import jakarta.validation.Valid;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private Session session;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @DeleteMapping("/{userId}/{commentId}")
    public ResponseEntity<?> delete(@PathVariable int userId,@PathVariable int commentId){
        this.commentService.delete(commentId,userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody AddCommentRequest request){
        return new ResponseEntity<>(this.commentService.add(request), HttpStatus.CREATED);
    }
}
