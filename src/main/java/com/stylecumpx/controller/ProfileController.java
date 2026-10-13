package com.stylecumpx.controller;

import com.stylecumpx.model.Profile;
import com.stylecumpx.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "*")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/save")
    public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) {
        Profile savedProfile = profileService.saveOrUpdateProfile(profile);
        return ResponseEntity.ok(savedProfile);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getProfile(@PathVariable Long userId) {
        return profileService.getProfileByUserId(userId)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }
}