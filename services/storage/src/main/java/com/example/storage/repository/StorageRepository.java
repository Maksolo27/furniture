package com.example.storage.repository;

import com.example.storage.entity.Ware;

import java.util.ArrayList;
import java.util.List;

public class StorageRepository {

    List<Ware> wares = new ArrayList<>();

    public StorageRepository () {
        wares.add (new Ware (0, "Phone", 200.0));
        wares.add (new Ware (1, "Computer", 500.0));
        wares.add (new Ware (2, "Laptop", 300.0));
    }

    public List<Ware> getAllWares () {
        return wares;
    }

}