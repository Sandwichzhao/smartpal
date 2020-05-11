package com.smartpal.inputorder.service;

import com.smartpal.inputorder.bean.QueryInputOrder;
import com.smartpal.inputorder.domain.InputPayEntity;
import org.springframework.data.domain.Page;

public interface InputPayService {
    Page<InputPayEntity> queryInputPayEntity(QueryInputOrder queryInputOrder);

    void deleteInputPayEntity(long id);

}
