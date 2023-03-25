package com.example.storage.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@JsonSerialize
@Entity
public class Ware {

    public Ware(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    @JsonProperty
    @Id
    private long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private double price;


    public Ware() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
