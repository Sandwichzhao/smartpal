package com.smartpal.inputorder.controller;

import com.smartpal.common.PageResult;
import com.smartpal.inputorder.bean.BaseInputOrderInfo;
import com.smartpal.inputorder.bean.LayTableInfo;
import com.smartpal.inputorder.bean.QueryInputOrder;
import com.smartpal.inputorder.domain.InputOrderEntity;
import com.smartpal.inputorder.service.InputOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Controller
@RequestMapping(value = "/v1")
public class InputOrderController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InputOrderService inputOrderService;

    /**
     * 采购订单查询
     *
     * @param headers
     * @param queryOrder
     * @return
     */
    @PostMapping(value = "/query/inputOrder")
//    public ResponseEntity getInputOrderINfo(@RequestHeader HttpHeaders headers){
    public ResponseEntity getInputOrderINfo(@RequestHeader HttpHeaders headers,
                                            @RequestBody QueryInputOrder queryOrder) {

        Page<InputOrderEntity> pageRet = inputOrderService.queryInputOrderEntity(queryOrder);
        Pageable pageable = pageRet.getPageable();
        int pageSize = pageable.getPageSize();
        int totalPage = pageRet.getTotalPages();

        List<InputOrderEntity> ret = pageRet.getContent();

//        PageResult<InputOrderEntity> pageResult = new PageResult();
//        pageResult.setResult(ret);
//        pageResult.setPage(queryOrder.getPage());
//        pageResult.setLimit(pageSize);
//        pageResult.setTotalPage(totalPage);

        LayTableInfo<InputOrderEntity> tableInfos = new LayTableInfo();
        tableInfos.setCode(0);
        tableInfos.setMsg("查询成功");
        tableInfos.setData(ret);
        tableInfos.setCount(pageRet.getTotalElements());

        return ResponseEntity.ok(tableInfos);


//        System.out.println("========");
//        return ResponseEntity.ok(null);
    }

    /**
     * 采购订单更新
     *
     * @param headers
     * @return
     */
    @PutMapping(value = "/inputOrder/{id}")
    public ResponseEntity updateInputOrderINfo(@RequestHeader HttpHeaders headers,
                                               @RequestBody BaseInputOrderInfo orderInfo) {

        InputOrderEntity inputOrderEntity = new InputOrderEntity(orderInfo);
        return ResponseEntity.ok(inputOrderService.updateInputOrderEntity(inputOrderEntity));
    }

    /**
     * 采购订单添加
     *
     * @param headers
     * @return
     */
    @PostMapping(value = "/inputOrder")
    public ResponseEntity addInputOrderINfo(@RequestHeader HttpHeaders headers,
                                            @RequestBody BaseInputOrderInfo orderInfo) {
        InputOrderEntity inputOrderEntity = new InputOrderEntity(orderInfo);
        String serialNumber = UUID.randomUUID().toString();
        inputOrderEntity.setSerialNumber(serialNumber);
        return ResponseEntity.ok(inputOrderService.addInputOrderEntity(inputOrderEntity));
    }


    /**
     * 采购订单删除
     *
     * @param headers
     * @return
     */
    @DeleteMapping(value = "/inputOrder/{id}")
    public ResponseEntity deleteInputOrderINfo(@RequestHeader HttpHeaders headers,
                                               @PathVariable(name = "id") long id) {

        inputOrderService.deleteInputOrderById(id);
        return ResponseEntity.ok(null);
    }

}
