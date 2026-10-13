package com.stylecumpx.service;

import com.stylecumpx.model.ClothingItem;
import com.stylecumpx.repository.ClothingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardrobeService {

    @Autowired
    private ClothingItemRepository clothingItemRepository;

    public ClothingItem addClothingItem(ClothingItem item) {
        return clothingItemRepository.save(item);
    }

    public List<ClothingItem> getUserWardrobe(Long userId) {
        return clothingItemRepository.findByUserId(userId);
    }

    public List<ClothingItem> getWardrobeByCategory(Long userId, String category) {
        return clothingItemRepository.findByUserIdAndCategory(userId, category);
    }

    public void deleteClothingItem(Long itemId) {
        clothingItemRepository.deleteById(itemId);
    }
}