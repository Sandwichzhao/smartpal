package com.smartpal.monitor.domain.repository;

import com.smartpal.monitor.domain.StoreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StoreRepository extends PagingAndSortingRepository<StoreEntity, Long> {
    Page<StoreEntity> findAllByStatus(int status);
}
