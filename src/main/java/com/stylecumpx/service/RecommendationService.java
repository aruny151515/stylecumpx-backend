package com.stylecumpx.service;

import com.stylecumpx.model.ClothingItem;
import com.stylecumpx.repository.ClothingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationService {

    @Autowired
    private ClothingItemRepository clothingRepository;

    public Map<String, Object> suggestOutfit(Long userId, String occasion) {
        List<ClothingItem> wardrobe = clothingRepository.findByUserId(userId);
        Map<String, Object> outfit = new HashMap<>();
        outfit.put("occasion", occasion);

        String targetType = switch (occasion.toLowerCase()) {
            case "interview", "formal" -> "Formal";
            case "fest", "party" -> "Trendy";
            case "traditional", "ethnic" -> "Traditional";
            case "sports", "gym" -> "Sporty";
            default -> "Casual";
        };

        Optional<ClothingItem> top = wardrobe.stream()
                .filter(i -> "Shirt".equalsIgnoreCase(i.getCategory()) && targetType.equalsIgnoreCase(i.getType()))
                .findAny()
                .or(() -> wardrobe.stream().filter(i -> "Shirt".equalsIgnoreCase(i.getCategory())).findAny());

        Optional<ClothingItem> bottom = wardrobe.stream()
                .filter(i -> "Pant".equalsIgnoreCase(i.getCategory()) && targetType.equalsIgnoreCase(i.getType()))
                .findAny()
                .or(() -> wardrobe.stream().filter(i -> "Pant".equalsIgnoreCase(i.getCategory())).findAny());

        Optional<ClothingItem> shoes = wardrobe.stream()
                .filter(i -> "Shoes".equalsIgnoreCase(i.getCategory()))
                .findAny();

        outfit.put("top", top.orElse(null));
        outfit.put("bottom", bottom.orElse(null));
        outfit.put("shoes", shoes.orElse(null));
        outfit.put("matchFound", top.isPresent() || bottom.isPresent());

        return outfit;
    }
}