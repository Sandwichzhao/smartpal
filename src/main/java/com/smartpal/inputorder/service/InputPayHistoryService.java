package com.smartpal.inputorder.service;

import com.smartpal.inputorder.domain.InputPayHistoryEntity;

import java.util.List;

public interface InputPayHistoryService {
    void addInputPayHistory(InputPayHistoryEntity entity);

    List<InputPayHistoryEntity> findInputPayHistoryEntityBySerialNumber(String serialNumber);
}
