package com.example.buyer.services;

import com.example.buyer.entities.Buyer;
import com.example.buyer.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;


    public List<Buyer> getAllBuyers () {
        return buyerRepository.findAll();
    }

    public void addBuyer (Buyer buyer) {

        buyerRepository.saveAndFlush(buyer);
    }

    public void updateBuyer (Buyer buyer) {

        buyerRepository.save(buyer);
    }

    public void deleteById (Long id) {

        buyerRepository.deleteById(id);
    }



}
