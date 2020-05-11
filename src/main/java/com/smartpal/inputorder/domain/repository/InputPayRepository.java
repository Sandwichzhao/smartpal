package com.smartpal.inputorder.domain.repository;

import com.smartpal.inputorder.domain.InputPayEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.sql.Timestamp;
import java.util.List;

public interface InputPayRepository extends PagingAndSortingRepository<InputPayEntity, Long> {
    List<InputPayEntity> findBySerialNumberLikeAndCreatedAtBetween(String serialNumber, Timestamp begin, Timestamp end);

    Page<InputPayEntity> findAll(Pageable pageable);

    Page<InputPayEntity> findByStatus(int status, Pageable pageable);



}
