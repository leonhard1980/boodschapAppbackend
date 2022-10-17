package com.example.demo.model;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "orderlines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private int amount;
//46:03
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


    //volledige constructor
    public OrderLine(Long orderId, int amount, Product product, double originalPrice, double orderPrice, boolean usedDiscount, Order order) {
        this.orderId = orderId;
        this.amount = amount;
        this.product = product;
        this.originalPrice = originalPrice;
        this.orderPrice = orderPrice;
        this.usedDiscount = usedDiscount;
        this.order = order;
    }

    //constructor zonder de usedDiscount (aangezien die null kan zijn)
    public OrderLine(Long orderId, int amount, Product product, double originalPrice, double orderPrice, Order order) {
        this.orderId = orderId;
        this.amount = amount;
        this.product = product;
        this.originalPrice = originalPrice;
        this.orderPrice = orderPrice;
        this.order = order;
    }

    //constructor met slechts drie parameters voor de test
    public OrderLine(int amount, double orderPrice) {
        this.amount = amount;
        this.orderPrice = orderPrice;
    }

    public int getOrderId(){
        return orderId;
    }

    // methode voor het uitrekenen van de prijs van de bestelling?
    // klopt deze berekening?
    public double calculateAmount(){
        return this.amount * this.orderPrice;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public boolean isUsedDiscount() {
        return usedDiscount;
    }

    public void setUsedDiscount(boolean usedDiscount) {
        this.usedDiscount = usedDiscount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
