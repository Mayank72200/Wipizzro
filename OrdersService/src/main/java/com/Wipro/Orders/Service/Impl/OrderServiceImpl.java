package com.Wipro.Orders.Service.Impl;

import com.Wipro.Orders.Entity.Items;
import com.Wipro.Orders.Entity.Orders;
import com.Wipro.Orders.Repository.OrderRepository;
import com.Wipro.Orders.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    RestTemplate restTemplate;

    private Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);


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
    public Orders getOrderById(String orderId) {
        return orderRepo.findById(orderId).get();
    }

    @Override
    public List<Items> getOrderItems(String orderId) {

        Orders order = orderRepo.findById(orderId).get();
        List<Items>items= order.getItems();
        return items;
    }


}
