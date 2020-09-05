package com.smartpal.monitor.service.impl;

import com.smartpal.common.Common;
import com.smartpal.monitor.bean.StoreGoodsQuery;
import com.smartpal.monitor.domain.GoodsEntity;
import com.smartpal.monitor.domain.repository.GoodsRepository;
import com.smartpal.monitor.service.StoreGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StoreGoodsServiceImpl implements StoreGoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Page<GoodsEntity> getStoreGoods(StoreGoodsQuery storeGoodsQuery) {
        PageRequest pageable = PageRequest.of(storeGoodsQuery.getCurrentPage() - 1, storeGoodsQuery.getPageNumber());
        return goodsRepository.findByStorePkAndStatus(storeGoodsQuery.getStorePk(), Common.ENABLE, pageable);
    }
}
