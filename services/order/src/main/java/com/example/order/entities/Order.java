package com.example.order.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private Double itemPrice;

    @Column(name = "item_quantity")
    private Integer quantity;
}
