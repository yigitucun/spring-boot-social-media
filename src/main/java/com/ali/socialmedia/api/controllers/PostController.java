package com.ali.socialmedia.api.controllers;

import com.ali.socialmedia.business.abstracts.PostService;
import com.ali.socialmedia.core.dto.requests.AddPostRequest;
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

    @PostMapping
    public ResponseEntity<?> add(@RequestParam("image") MultipartFile image,@Valid @ModelAttribute AddPostRequest request) throws IOException {
        return new ResponseEntity<>(this.postService.add(image,request), HttpStatus.CREATED);
    }
}
