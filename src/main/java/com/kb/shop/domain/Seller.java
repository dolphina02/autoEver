package com.kb.shop.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SellerGrade sellerGrade;

    private Double margin;

    private String policy;
    private String category;
}
