package com.example.buyer.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Buyer {

    public Buyer(long id, String firstName, String lastName, String phone, String city, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
        this.address = address;
    }

    public Buyer(){}

    @JsonProperty
    private long id;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String phone;

    @JsonProperty
    private String city;

    @JsonProperty
    private String address;

}
