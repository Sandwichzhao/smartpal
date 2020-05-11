package com.smartpal.inputorder.service.impl;

import com.smartpal.inputorder.domain.InputPayHistoryEntity;
import com.smartpal.inputorder.domain.repository.InputPayHistoryRepository;
import com.smartpal.inputorder.service.InputPayHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputPayHistoryServiceImpl implements InputPayHistoryService {
    @Autowired
    private InputPayHistoryRepository inputPayHistoryRepository;

    @Override
    public void addInputPayHistory(InputPayHistoryEntity entity) {
        inputPayHistoryRepository.save(entity);
    }

    @Override
    public List<InputPayHistoryEntity> findInputPayHistoryEntityBySerialNumber(String serialNumber) {

        return inputPayHistoryRepository.findBySerialNumber(serialNumber);
    }
}
