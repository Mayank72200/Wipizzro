package com.Wipro.Orders.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    private String orderId;
    private String userId;
    private String type;
    private String time;

    @OneToMany(mappedBy = "orders")
    List<Items> items= new ArrayList<>();






}
