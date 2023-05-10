package com.example.order.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderId;
    private String customerName;
    private String itemName;
    private double itemPrice;
    private int quantity;
}
