package com.example.buyer.services;

import com.example.buyer.entities.Buyer;
import com.example.buyer.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {

    private final BuyerRepository buyerRepository = new BuyerRepository();

    public Buyer getBuyerById(long id){return buyerRepository.getById((int)id);}

    public List<Buyer> getAllBuyers(){return buyerRepository.getAllBuyers();}

}
