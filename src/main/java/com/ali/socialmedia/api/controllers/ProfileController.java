package com.ali.socialmedia.api.controllers;

import com.ali.socialmedia.business.abstracts.ProfileService;
import com.ali.socialmedia.core.dto.requests.UpdateProfileRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestParam("image") MultipartFile image, @ModelAttribute UpdateProfileRequest request) throws IOException {
        return new ResponseEntity<>(this.profileService.update(request,image), HttpStatus.OK);
    }

}
