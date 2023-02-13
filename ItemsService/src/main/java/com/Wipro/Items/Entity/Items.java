package com.Wipro.Items.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Items")
public class Items {

    @Id
    @ManyToMany
    private String itemId;
    @Column(name="NAME")
    private String name;
    @Column(name="CATEGORY")
    private String category;
    @Column(name="DESCRIPTION")
    private String description;
    @Column(name="PRICE")
    private float price;


}
