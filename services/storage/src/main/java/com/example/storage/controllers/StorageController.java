package com.example.storage.controllers;

import com.example.storage.entity.Ware;
import com.example.storage.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/storage")
public class StorageController {

    @Autowired
    StorageService storageService;


    @GetMapping()
    public ResponseEntity<List<Ware>> getAllWares () {
        System.out.println (storageService.getAllWares ());
        return ResponseEntity.ok (storageService.getAllWares ());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ware> getAllWares (@PathVariable String id) {
        return ResponseEntity.ok (storageService.getAllWares ().get (Integer.parseInt(id)));

    }


}
