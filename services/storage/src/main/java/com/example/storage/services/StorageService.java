package com.example.storage.services;

import com.example.storage.repository.StorageRepository;
import com.example.storage.entity.Ware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {


    @Autowired
    private StorageRepository warehouseRepository;


    public List<Ware> getAllWares () {
        return warehouseRepository.findAll();
    }

    public void addWare (Ware ware) {
        warehouseRepository.saveAndFlush(ware);
    }

    public void update (Ware ware) {
        warehouseRepository.save(ware);
    }

    public void deleteById (Long id) {
        warehouseRepository.deleteById(id);
    }



}