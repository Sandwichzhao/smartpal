package com.smartpal.monitor.controller;

import com.smartpal.common.PageResult;
import com.smartpal.common.ResponseResult;
import com.smartpal.monitor.domain.GoodsEntity;
import com.smartpal.monitor.service.StoreGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.smartpal.monitor.bean.*;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/v1")
public class StoreGoodsController {

    @Autowired
    private StoreGoodsService storeGoodsService;

    @GetMapping(value = "/storeGoods")
    public ResponseEntity<?> getStore(@RequestHeader HttpHeaders headers,
                                      @RequestBody StoreGoodsQuery storeGoodsQuery) {
        Page<GoodsEntity> result = storeGoodsService.getStoreGoods(storeGoodsQuery);
        Pageable pageable = result.getPageable();

        List<GoodsEntity> list = result.getContent();
        List<StoreGoods> respStoreGoods = list.stream().map(entity -> new StoreGoods(entity.getPk(), entity.getSnapshopTime(), entity.getName(),
                entity.getPirce(), entity.getUrl(), entity.getStatement(), entity.getUpdateAt()))
                .collect(Collectors.toList());

        PageResult<StoreGoods> pageResult = new PageResult();
        pageResult.setResult(respStoreGoods);
        pageResult.setTotalPage(result.getTotalPages());
        pageResult.setCurrentPage(pageable.getPageSize());
        pageResult.setPageNumber(pageable.getPageNumber());

        return new ResponseEntity(pageResult, HttpStatus.OK);
    }


}
