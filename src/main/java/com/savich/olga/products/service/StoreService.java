package com.savich.olga.products.service;

import com.savich.olga.products.dao.StoreDao;
import com.savich.olga.products.dto.BucketDto;
import com.savich.olga.products.dto.StoreDto;
import com.savich.olga.products.entity.Bucket;
import com.savich.olga.products.entity.Store;
import com.savich.olga.products.exception.BucketNotFoundException;
import com.savich.olga.products.mapping.StoreMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {
    private final StoreDao storeDao;
    private final StoreMapper storeMapper;

    public StoreService(StoreDao storeDao, StoreMapper storeMapper) {
        this.storeDao = storeDao;
        this.storeMapper = storeMapper;
    }

    public Store saveStore(StoreDto storeDto) {
        return storeDao.save(storeMapper.mapToStore(storeDto));
    }

    public void updateStore(int id, StoreDto storeDto) {
        Store store = storeMapper.mapToStore(storeDto);
        store.setId(id);
        storeDao.save(store);
    }

    public void deleteStoreById(int id) {
        storeDao.deleteById(id);
    }

    public Store getStoreById(int id) {
        return storeDao.findById(id).orElseThrow(() ->
                new BucketNotFoundException("Store not found, id is incorrect"));
    }

    public List<Store> getAllStores() {
        List<Store> storeList = new ArrayList<>();
        storeDao.findAll().forEach(store -> storeList.add(store));
        return storeList;
    }
}
