package com.example.buyer.controllers;


import com.example.buyer.entities.Buyer;
import com.example.buyer.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @GetMapping()
    public ResponseEntity<List<Buyer>> getAllBuyers(){
        System.out.println(buyerService.getAllBuyers());
        return ResponseEntity.ok(buyerService.getAllBuyers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getAllBuyers(@PathVariable String id){
        return ResponseEntity.ok(buyerService.getBuyerById(Integer.parseInt(id)));
    }
}
