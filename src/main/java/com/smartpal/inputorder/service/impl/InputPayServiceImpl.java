package com.smartpal.inputorder.service.impl;

import com.smartpal.inputorder.bean.QueryInputOrder;
import com.smartpal.inputorder.domain.InputPayEntity;
import com.smartpal.inputorder.domain.repository.InputPayRepository;
import com.smartpal.inputorder.service.InputPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class InputPayServiceImpl implements InputPayService {

    private static int ENABLE_STATUS = 1;
    private static int DISENABLE_STATUS = 0;

    @Autowired
    private InputPayRepository inputPayRepository;

    @Override
    public Page<InputPayEntity> queryInputPayEntity(QueryInputOrder queryInfo) {
        PageRequest pageable = PageRequest.of(queryInfo.getCurrentPage() - 1, queryInfo.getPageNumber());
        Page<InputPayEntity> pageResult = null;
        if (StringUtils.isEmpty(queryInfo.getSerialNumber())
                && StringUtils.isEmpty(queryInfo.getBeginAt())
                && StringUtils.isEmpty(queryInfo.getEndAt())) {
            pageResult = inputPayRepository.findByStatus(ENABLE_STATUS, pageable);

        } else if (StringUtils.hasText(queryInfo.getSerialNumber())
                && StringUtils.hasText(queryInfo.getEndAt())
                && StringUtils.hasText(queryInfo.getBeginAt())) {
            String serial = "%" + queryInfo.getSerialNumber() + "%";
//            inputOrderRepository.findBySerialNumberLikeAndCreatedAtBetween(serial, queryInputOrder.getBeginAt(), queryInputOrder.getEndAt())

        }

        return inputPayRepository.findByStatus(ENABLE_STATUS, pageable);
    }

    @Override
    public void deleteInputPayEntity(long id) {
        InputPayEntity entity = inputPayRepository.findById(id).get();
        entity.setStatus(DISENABLE_STATUS);
        inputPayRepository.save(entity);

    }
}
