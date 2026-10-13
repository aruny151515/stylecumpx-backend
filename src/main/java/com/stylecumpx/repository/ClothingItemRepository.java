package com.stylecumpx.repository;

import com.stylecumpx.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
    List<ClothingItem> findByUserId(Long userId);
    List<ClothingItem> findByUserIdAndCategory(Long userId, String category);
    List<ClothingItem> findByUserIdAndType(Long userId, String type);
}