package com.savich.olga.products.controller;

import com.savich.olga.products.dto.StoreDto;
import com.savich.olga.products.entity.Bucket;
import com.savich.olga.products.entity.Store;
import com.savich.olga.products.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoresController {
    private final StoreService storeService;


    public StoresController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/get/{id}")
    public Store getStore(@PathVariable(value = "id") int id) {
        return storeService.getStoreById(id);
    }

    @PostMapping("/ ")
    public Store saveStore(@RequestBody StoreDto storeDto) {
        return storeService.saveStore(storeDto);
    }

    @PutMapping("/update/{id}")
    public void updateStore(@PathVariable(value = "id") int id, @RequestBody StoreDto storeDto) {
        storeService.updateStore(id, storeDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStore(@PathVariable(value = "id") int id) {
        storeService.deleteStoreById(id);
    }
}
