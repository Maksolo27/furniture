package com.example.order;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.order.controller.OrderController;
import com.example.order.entities.Order;
import com.example.order.services.OrderService;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

public class OrderControllerTest {

    @Mock
    OrderService orderService;

    @InjectMocks
    OrderController orderController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCircuitBreaker() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .slidingWindowSize(5)
                .minimumNumberOfCalls(4)
                .build();
        when(orderService.getAllOrders()).thenThrow(new RuntimeException("Failed to fetch orders"));

        List<ResponseEntity<List<Order>>> responses = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            try {
                ResponseEntity<List<Order>> response = orderController.getAllOrders();
                responses.add(response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, responses.get(0).getStatusCode());
        Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, responses.get(1).getStatusCode());
        Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, responses.get(2).getStatusCode());
        Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, responses.get(3).getStatusCode());
        Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, responses.get(4).getStatusCode());
        Assertions.assertEquals(HttpStatus.SERVICE_UNAVAILABLE, responses.get(5).getStatusCode());
    }
}
