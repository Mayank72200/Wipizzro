package com.Wipro.Orders.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Items {


    @Id
    private String itemId;
    private String name;
    private String category;
    private String description;
    private float price;
    private int quantity;

    @ManyToOne
    private Orders orders;
}
