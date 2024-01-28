package com.ali.socialmedia.api.controllers;

import com.ali.socialmedia.business.abstracts.ProfileService;
import com.ali.socialmedia.core.dto.requests.UpdateProfileRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/{followedId}/{followingId}")
    public ResponseEntity<?> follow(@PathVariable int followedId,@PathVariable int followingId){
        this.profileService.follow(followedId,followingId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detail(@PathVariable int id){
        return ResponseEntity.ok(this.profileService.detail(id));
    }

    @PutMapping
    public ResponseEntity<?> update( @RequestBody UpdateProfileRequest request){
        return new ResponseEntity<>(this.profileService.update(request), HttpStatus.OK);
    }

}
