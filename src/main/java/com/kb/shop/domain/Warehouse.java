package com.kb.shop.domain;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "warehouses")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    // Other fields, getters and setters
}
