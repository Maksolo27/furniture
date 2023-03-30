package com.example.order.controller;

import com.example.order.entities.Order;
import com.example.order.services.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("create")
    public void createOrder (@RequestBody String json) {
        Gson gson = new Gson ();
        Order order = gson.fromJson (json, Order.class);
        orderService.addOrder(order);
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrders () {
        System.out.println (orderService.getAllOrders());
        return ResponseEntity.ok (orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById (@PathVariable String id) {
        return ResponseEntity.ok (orderService.getAllOrders().get(Integer.parseInt(id)));
    }

    @PostMapping("update/{id}")
    public void updateOrder (@PathVariable String id, @RequestBody String json) {
        Gson gson = new Gson ();
        Order order = gson.fromJson (json, Order.class);
        Order chosenOrder = orderService.getAllOrders().get(Integer.parseInt(id));
        chosenOrder.setCustomerName(order.getCustomerName());
        chosenOrder.setItemName(order.getItemName());
        chosenOrder.setItemPrice(order.getItemPrice());
        chosenOrder.setQuantity(order.getQuantity());
        orderService.updateOrder(order);
    }

    @DeleteMapping("delete/{id}")
    public void deleteOrder (@PathVariable String id) {
        orderService.deleteById(Math.toIntExact(Long.valueOf(id)));
    }
}



