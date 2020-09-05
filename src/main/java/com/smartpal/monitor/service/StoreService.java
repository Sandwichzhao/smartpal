package com.smartpal.monitor.service;

import com.smartpal.monitor.domain.StoreEntity;

import java.util.List;

public interface StoreService {
    List<StoreEntity> getAllStoreList();

    StoreEntity addStoreEntity(StoreEntity entity);

    StoreEntity updateStoreEntity(StoreEntity entity);

    StoreEntity deleteStoreEntity(long pk);
}
