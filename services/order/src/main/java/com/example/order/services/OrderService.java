package com.example.order.services;

import com.example.order.entities.Order;
import com.example.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository = new OrderRepository();

    public List<Order> getAllOrder () {
        return orderRepository.findAll();
    }

    public Order getById(Integer id){
        return orderRepository.findById(id);
    }
}
