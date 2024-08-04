package com.myecommerce.eccomerceapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private LocalDateTime orderDate;

    // Why use LocalDateTime? It's the modern Java way to handle dates and times,
    // and it doesn't carry timezone information which simplifies our logic.
}
