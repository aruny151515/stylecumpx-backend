package com.stylecumpx.controller;

import com.stylecumpx.model.ClothingItem;
import com.stylecumpx.service.WardrobeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wardrobe")
@CrossOrigin(origins = "*")
public class WardrobeController {

    @Autowired
    private WardrobeService wardrobeService;

    @PostMapping("/add")
    public ResponseEntity<ClothingItem> addItem(@RequestBody ClothingItem item) {
        return ResponseEntity.ok(wardrobeService.addClothingItem(item));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ClothingItem>> getWardrobe(@PathVariable Long userId) {
        return ResponseEntity.ok(wardrobeService.getUserWardrobe(userId));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long itemId) {
        wardrobeService.deleteClothingItem(itemId);
        return ResponseEntity.ok("Item deleted successfully");
    }
}