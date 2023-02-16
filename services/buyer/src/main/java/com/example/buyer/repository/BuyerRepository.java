package com.example.buyer.repository;

import com.example.buyer.entities.Buyer;

import java.util.ArrayList;
import java.util.List;

public class BuyerRepository {

    List<Buyer> buyers = new ArrayList<Buyer>(){{
        add(new Buyer(0,"John","John","051510","Toronto","5 Av. 12"));
        add(new Buyer(1,"James","James","058952","Nashville","8 Av. 11"));
        add(new Buyer(2,"Paul","Paul","055684","Canberra","2 Av. 8"));
    }};

    public Buyer getById(long id){return buyers.get((int)id);}

    public List<Buyer> getAllBuyers(){return buyers;}


}
