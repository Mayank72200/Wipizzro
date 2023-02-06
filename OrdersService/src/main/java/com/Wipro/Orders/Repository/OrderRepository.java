package com.Wipro.Orders.Repository;

import com.Wipro.Orders.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,String> {

    //Implement custom methods here

    List<Orders> findByUserId(String userId);



}
