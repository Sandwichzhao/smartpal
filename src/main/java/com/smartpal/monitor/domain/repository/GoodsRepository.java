package com.smartpal.monitor.domain.repository;

import com.smartpal.monitor.domain.GoodsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GoodsRepository extends PagingAndSortingRepository<GoodsEntity, Long> {
    Page<GoodsEntity> findByStorePkAndStatus(long storePk,int status, Pageable pageable);
}
