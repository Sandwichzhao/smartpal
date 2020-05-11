package com.smartpal.inputorder.domain.repository;

import com.smartpal.inputorder.domain.InputPayHistoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InputPayHistoryRepository extends PagingAndSortingRepository<InputPayHistoryEntity, Long> {

    List<InputPayHistoryEntity> findBySerialNumber(String serrialNumber);
}
