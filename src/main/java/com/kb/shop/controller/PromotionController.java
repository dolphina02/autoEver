package com.kb.shop.controller;

import com.kb.shop.domain.Promotion;
import com.kb.shop.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promotion/{id}")
    public Optional<Promotion> getPromotionInfo(@PathVariable Long id) {
        return promotionService.getPromotionInfo(id);
    }

    @DeleteMapping("/promotion/{id}")
    public void deletePromotionInfo(@PathVariable Long id) {
        promotionService.deletePromotionInfo(id);
    }

    @PostMapping("/promotion")
    public ResponseEntity<Promotion> setPromotionInfo(@RequestParam Promotion promotion) {
        Optional<Promotion> newPromotion = promotionService.setPromotionInfo(promotion);
        if (newPromotion.isPresent()) {
            return ResponseEntity.ok(newPromotion.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
