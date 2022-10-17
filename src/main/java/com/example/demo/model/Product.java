package com.example.demo.model;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String productName;
    @Column(nullable = false)
    private double price;

    private double discountPrice;
    private String description;


    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "orderLine_id")
    private Collection<OrderLine> orderLines;



    // getters en setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
