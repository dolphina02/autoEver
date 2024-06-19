package com.kb.shop.service;

import com.kb.shop.domain.Promotion;
import com.kb.shop.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public Optional<Promotion> getPromotionInfo(Long id) {
        return promotionRepository.findById(id);
    }

    public void deletePromotionInfo(Long id) {
        promotionRepository.deleteById(id);
    }

    public Optional<Promotion> setPromotionInfo(Promotion promotion) {
        promotionRepository.save(promotion);
        return promotionRepository.findById(promotion.getId());
    }
}
