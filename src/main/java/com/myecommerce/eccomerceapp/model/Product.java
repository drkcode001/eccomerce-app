package com.myecommerce.eccomerceapp.model;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;

    // Why use BigDecimal for price? It's crucial for financial calculations to avoid rounding errors.
}
