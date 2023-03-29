package com.example.buyer.controllers;


import com.example.buyer.entities.Buyer;
import com.example.buyer.services.BuyerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/buyer")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @PostMapping("create")
    public void createBuyer (@RequestBody String json) {
        Gson gson = new Gson ();
        Buyer buyer = gson.fromJson (json, Buyer.class);
        buyerService.addBuyer(buyer);
    }

    @GetMapping()
    public ResponseEntity<List<Buyer>> getAllBuyers () {
        System.out.println (buyerService.getAllBuyers());
        return ResponseEntity.ok (buyerService.getAllBuyers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById (@PathVariable String id) {
        return ResponseEntity.ok (buyerService.getAllBuyers().get(Integer.parseInt(id)));
    }

    @PostMapping("update/{id}")
    public void updateBuyer (@PathVariable String id, @RequestBody String json) {
        Gson gson = new Gson ();
        Buyer buyer = gson.fromJson (json, Buyer.class);
        Buyer chosenBuyer = buyerService.getAllBuyers().get(Integer.parseInt(id));
        chosenBuyer.setFirstName(buyer.getFirstName());
        chosenBuyer.setLastName(buyer.getLastName());
        chosenBuyer.setPhone(buyer.getPhone());
        chosenBuyer.setCity(buyer.getCity());
        chosenBuyer.setAddress(buyer.getAddress());
        buyerService.updateBuyer(buyer);
    }

    @DeleteMapping("delete/{id}")
    public void deleteBuyer (@PathVariable String id) {
        buyerService.deleteById(Long.valueOf(id));
    }
}
