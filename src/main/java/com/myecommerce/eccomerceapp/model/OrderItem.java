package com.myecommerce.eccomerceapp.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private int quantity;

    // Why separate OrderItem from Order? This allows for a more flexible structure
    // where we can easily add or remove items from an order.
}
