package com.Wipro.Orders.Service.Impl;

import com.Wipro.Orders.Entity.Orders;
import com.Wipro.Orders.Repository.OrderRepository;
import com.Wipro.Orders.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Override
    public Orders create(Orders orders) {
        //generate Unique orderID
        String randomOrderId =UUID.randomUUID().toString();
        orders.setOrderId(randomOrderId);
        return orderRepo.save(orders);
    }

    @Override
    public List<Orders> getOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Orders> getOrdersByUserId(String userId) {
        return orderRepo.findByUserId(userId);
    }

    @Override
    public Orders getOrderById(String orderid) {
        return orderRepo.findById(orderid).get();
    }


}
