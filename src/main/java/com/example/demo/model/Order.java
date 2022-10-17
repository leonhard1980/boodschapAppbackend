package com.example.demo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Collection<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Collection<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public AppUser getUserId() {
        return appUserId;
    }

    public void setUserId(AppUser appUserId) {
        this.appUserId = appUserId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderlines_id", referencedColumnName = "id")
    private Collection<OrderLine> orderLines;


    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private AppUser appUserId;

    private Date orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /* CODE VAN ROBERTJAN, OM DE EINDPRIJS VAST TE STELLEN.
    public double calculateAmount() {
        return this.quanty * this.unitprice;
    }*/

    //in LES17 staan twee voorbeelden van unittesten.
    // De unittest staat in de map test (en dan down the line)
    // die verwijzen naar methodes uit het MODEL (ORDER).
}
