package com.example.demo.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "orderlines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private int amount;

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private double originalPrice;
    @Column(nullable = false)
    private double orderPrice;
    @Column(nullable = false)
    private boolean usedDiscount;

    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
