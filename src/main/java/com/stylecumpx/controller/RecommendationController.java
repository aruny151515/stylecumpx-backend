package com.stylecumpx.controller;

import com.stylecumpx.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "*")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Map<String, Object>> getOutfit(
            @PathVariable Long userId, 
            @RequestParam(defaultValue = "casual") String occasion) {
        
        Map<String, Object> outfit = recommendationService.suggestOutfit(userId, occasion);
        return ResponseEntity.ok(outfit);
    }
}