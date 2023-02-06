package com.Wipro.Orders.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    private String itemId;

    @Transient
    List<Items> items= new ArrayList<>();






}
