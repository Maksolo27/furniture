package com.example.order.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@Table(schema = "orders")
public class Order {
    @JsonProperty
    @Id
    private Long orderid;

    @JsonProperty
    private String itemname;

    @JsonProperty
    private float itemprice;

    public Order(long orderid, String itemname, float itemprice) {
        this.orderid = orderid;
        this.itemname = itemname;
        this.itemprice = itemprice;
    }

    public Order(){}

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public float getItemprice() {
        return itemprice;
    }

    public void setItemprice(float itemprice) {
        this.itemprice = itemprice;
    }
}
