package com.savich.olga.products.mapping;

import com.savich.olga.products.dto.StoreDto;
import com.savich.olga.products.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    public Store mapToStore(StoreDto storeDto) {
        Store store = new Store();
        store.setName(storeDto.getName());
        return store;
    }
}
