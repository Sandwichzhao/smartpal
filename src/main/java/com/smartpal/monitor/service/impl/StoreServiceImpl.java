package com.smartpal.monitor.service.impl;

import com.smartpal.common.Common;
import com.smartpal.monitor.domain.StoreEntity;
import com.smartpal.monitor.domain.repository.StoreRepository;
import com.smartpal.monitor.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<StoreEntity> getAllStoreList() {
        return storeRepository.findAllByStatus(Common.ENABLE).getContent();
    }

    @Override
    public StoreEntity addStoreEntity(StoreEntity entity) {
        return storeRepository.save(entity);
    }

    @Override
    public StoreEntity updateStoreEntity(StoreEntity entity) {
        StoreEntity dbEntity = storeRepository.findById(entity.getPk()).get();
        dbEntity.setUrl(entity.getUrl());
        dbEntity.setName(entity.getName());
        dbEntity.setNote(entity.getNote());
        return storeRepository.save(dbEntity);
    }

    @Override
    public StoreEntity deleteStoreEntity(long pk) {
        StoreEntity dbEntity = storeRepository.findById(pk).get();
        dbEntity.setStatus(Common.DISENABLE);
        return storeRepository.save(dbEntity);
    }
}
