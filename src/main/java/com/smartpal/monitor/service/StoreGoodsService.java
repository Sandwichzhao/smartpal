package com.smartpal.monitor.service;


import com.smartpal.monitor.bean.StoreGoodsQuery;
import com.smartpal.monitor.domain.GoodsEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StoreGoodsService {
    Page<GoodsEntity> getStoreGoods(StoreGoodsQuery storeGoodsQuery);
}
