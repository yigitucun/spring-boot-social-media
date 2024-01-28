package com.ali.socialmedia.api.controllers;

import com.ali.socialmedia.business.abstracts.PostService;
import com.ali.socialmedia.core.dto.requests.AddPostRequest;
import com.ali.socialmedia.core.dto.requests.UpdatePostRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @DeleteMapping("/{userId}/{postId}")
    public ResponseEntity<?> delete(@PathVariable int userId,@PathVariable int postId) throws IOException{
        this.postService.deleteById(userId,postId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdatePostRequest request){
        return ResponseEntity.ok(this.postService.update(request));
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody AddPostRequest request)  {
        return new ResponseEntity<>(this.postService.add(request), HttpStatus.CREATED);
    }
}
