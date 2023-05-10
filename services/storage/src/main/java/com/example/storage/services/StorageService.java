package com.example.storage.services;

import com.example.storage.repository.StorageRepository;
import com.example.storage.entity.Ware;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {


    private StorageRepository warehouseRepository = new StorageRepository ();


    public List<Ware> getAllWares () {
        return warehouseRepository.getAllWares ();
    }



}