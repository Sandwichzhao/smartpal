package com.smartpal.inputorder.domain.repository;

import com.smartpal.inputorder.domain.InputOrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;

public interface InputOrderRepository extends PagingAndSortingRepository<InputOrderEntity, Long> {
    List<InputOrderEntity> findBySerialNumberLikeAndCreatedAtBetween(String serialNumber, Timestamp begin, Timestamp end);

    Page<InputOrderEntity> findAll(Pageable pageable);

    Page<InputOrderEntity> findByStatus(int status, Pageable pageable);



}
