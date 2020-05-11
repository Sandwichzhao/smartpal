package com.smartpal.inputorder.service;

import com.smartpal.inputorder.bean.QueryInputOrder;
import com.smartpal.inputorder.domain.InputOrderEntity;
import org.springframework.data.domain.Page;

public interface InputOrderService {

    void deleteInputOrderById(long pk);

    InputOrderEntity addInputOrderEntity(InputOrderEntity entity);

    InputOrderEntity updateInputOrderEntity(InputOrderEntity entity);

    Page<InputOrderEntity> queryInputOrderEntity(QueryInputOrder queryInputOrder);
}
