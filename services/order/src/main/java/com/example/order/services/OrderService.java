package com.example.order.services;

import com.example.order.entities.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder () {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(Long id){
        return orderRepository.findById(id);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}