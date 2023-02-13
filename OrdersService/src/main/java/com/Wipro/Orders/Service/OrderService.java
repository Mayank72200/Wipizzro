package com.Wipro.Orders.Service;


import com.Wipro.Orders.Entity.Items;
import com.Wipro.Orders.Entity.Orders;
import org.apache.catalina.User;

import java.util.List;

public interface OrderService {

    //create orders

    Orders create(Orders orders);

    //getAll orders

    List<Orders> getOrders();


    //getbyuserId

    List<Orders> getOrdersByUserId(String userId);


    //getOrderById

    Orders getOrderById(String orderId);

    List<Items> getOrderItems(String OrderId);


}
