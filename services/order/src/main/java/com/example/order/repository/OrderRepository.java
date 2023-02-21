package com.example.order.repository;

import com.example.order.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    static List<Order> orders = new ArrayList<>() {{
        add(new Order(234, "John", "Sofa", 234, 24));
        add(new Order(123, "James", "Table", 456, 120));
        add(new Order(678, "Paul", "Chair", 8949, 110));
    }};


    public List<Order> findAll() {
        return orders;
    }

    public Order findById(Integer id){
        return orders.stream().filter(x -> x.getOrderId() == id).findFirst().orElse(null);
    }

}