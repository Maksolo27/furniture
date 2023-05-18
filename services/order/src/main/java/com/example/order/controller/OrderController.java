package com.example.order.controller;

import com.example.order.entities.Order;
import com.example.order.services.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    private boolean isPaused = false;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "emails";
    private static final String ROUTING_KEY_CREATE_ORDER = "create_order";
    @PostMapping("create")
    public void createOrder (@RequestBody String json) {
        Gson gson = new Gson ();
        Order order = gson.fromJson (json, Order.class);
        orderService.addOrder(order);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_CREATE_ORDER, gson.toJson(order));
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrders () {
        System.out.println (orderService.getAllOrders());
        return ResponseEntity.ok (orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById (@PathVariable String id) throws InterruptedException {
        if (isPaused) {
            Thread.sleep (10000);
        }
        return ResponseEntity.ok (orderService.getAllOrders().get(Integer.parseInt(id)));
    }
    @PostMapping("pause")
    public void pause() {
        isPaused = !isPaused;
    }
    @PostMapping("update/{id}")
    public void updateOrder (@PathVariable String id, @RequestBody String json) {
        Gson gson = new Gson ();
        Order order = gson.fromJson (json, Order.class);
        Order chosenOrder = orderService.getAllOrders().get(Integer.parseInt(id));
        chosenOrder.setItemname(order.getItemname());
        chosenOrder.setItemprice(order.getItemprice());
        orderService.updateOrder(order);
    }

    @DeleteMapping("delete/{id}")
    public void deleteOrder (@PathVariable String id) {
        orderService.deleteById(Long.valueOf(id));
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


