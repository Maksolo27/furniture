package com.example.order.controller;

import com.example.order.entities.Order;
import com.example.order.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrder(){
        System.out.println(orderService.getAllOrder());
        return ResponseEntity.ok( orderService.getAllOrder());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getAllOrder(@PathVariable Integer id){
        return ResponseEntity.ok(orderService.getById(id));
    }
}

