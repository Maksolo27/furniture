package com.example.storage.controllers;

import com.example.storage.entity.Ware;
import com.example.storage.services.StorageService;
import com.google.gson.Gson;
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
    public ResponseEntity<Ware> getWareById (@PathVariable String id) {
        return ResponseEntity.ok (storageService.getAllWares ().get (Integer.parseInt(id)));
    }

    @DeleteMapping("delete/{id}")
    public void deleteWare (@PathVariable String id) {
        storageService.deleteById (Long.valueOf(id));
    }

    @PostMapping("update/{id}")
    public void updateWare (@PathVariable String id, @RequestBody String json) {
        Gson gson = new Gson ();
        Ware ware = gson.fromJson (json, Ware.class);
        Ware previousWare = storageService.getAllWares().get(Integer.parseInt(id));
        previousWare.setName(ware.getName ());
        previousWare.setPrice(ware.getPrice ());
        storageService.update (ware);
    }

    @PostMapping("create")
    public void createWare (@RequestBody String json) {
        Gson gson = new Gson ();
        Ware ware = gson.fromJson (json, Ware.class);
        storageService.addWare(ware);
    }


}
