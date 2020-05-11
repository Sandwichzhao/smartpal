package com.smartpal.inputorder.service.impl;

import com.smartpal.common.PageInfo;
import com.smartpal.inputorder.bean.QueryInputOrder;
import com.smartpal.inputorder.domain.InputOrderEntity;
import com.smartpal.inputorder.domain.repository.InputOrderRepository;
import com.smartpal.inputorder.service.InputOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class InputOrderServiceImpl implements InputOrderService {

    private static int ENABLE_STATUS = 1;
    private static int DISENABLE_STATUS = 0;
    @Autowired
    private InputOrderRepository inputOrderRepository;


    /**
     * 删除
     *
     * @param pk
     */
    @Override
    public void deleteInputOrderById(long pk) {
        Optional<InputOrderEntity> optional = inputOrderRepository.findById(pk);
        if (optional.isPresent()) {
            InputOrderEntity entity = optional.get();
            entity.setStatus(DISENABLE_STATUS);
            inputOrderRepository.save(entity);
        }
    }

    /**
     * 添加
     *
     * @param entity
     * @return
     */
    @Override
    public InputOrderEntity addInputOrderEntity(InputOrderEntity entity) {
        return inputOrderRepository.save(entity);
    }

    @Override
    public InputOrderEntity updateInputOrderEntity(InputOrderEntity entity) {
        Optional<InputOrderEntity> entityOptional = inputOrderRepository.findById(entity.getId());

        if (entityOptional.isPresent()) {
            return inputOrderRepository.save(entity);
        }
        return null;
    }

    @Override
    public Page<InputOrderEntity> queryInputOrderEntity(QueryInputOrder queryInfo) {
        PageRequest pageable = PageRequest.of(queryInfo.getPage() - 1, queryInfo.getLimit());
        Page<InputOrderEntity> pageResult = null;
        if (StringUtils.isEmpty(queryInfo.getSerialNumber())
                && StringUtils.isEmpty(queryInfo.getBeginAt())
                && StringUtils.isEmpty(queryInfo.getEndAt())) {
            pageResult = inputOrderRepository.findByStatus(ENABLE_STATUS, pageable);

        } else if (StringUtils.hasText(queryInfo.getSerialNumber())
                && StringUtils.hasText(queryInfo.getEndAt())
                && StringUtils.hasText(queryInfo.getBeginAt())) {
            String serial = "%" + queryInfo.getSerialNumber() + "%";
//            inputOrderRepository.findBySerialNumberLikeAndCreatedAtBetween(serial, queryInputOrder.getBeginAt(), queryInputOrder.getEndAt())

        }

        return inputOrderRepository.findByStatus(ENABLE_STATUS, pageable);
    }
}
