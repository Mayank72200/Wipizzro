package com.Wipro.Orders.Controller;

import com.Wipro.Orders.Entity.Orders;
import com.Wipro.Orders.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint to crete any order
    @PostMapping("/createorder")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order){

        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(order));
    }

    // Endpoint to getAll orders

    @GetMapping("/")
    public ResponseEntity<List<Orders>> getOrders(){

        return ResponseEntity.ok(orderService.getOrders());
    }

    // Endpoint to get order by customerId

    @GetMapping("/{userId}")
    public ResponseEntity <List<Orders>> getByUserId(@PathVariable String userId){

        return ResponseEntity.ok(orderService.getOrdersByUserId(userId));
    }



}
