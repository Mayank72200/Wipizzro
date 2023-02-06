package com.Wipro.Orders.Service;


import com.Wipro.Orders.Entity.Orders;

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




}
