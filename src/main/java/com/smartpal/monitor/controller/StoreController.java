package com.smartpal.monitor.controller;

import com.smartpal.common.ResponseResult;
import com.smartpal.monitor.bean.Store;
import com.smartpal.monitor.domain.StoreEntity;
import com.smartpal.monitor.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/v1")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping(value = "/store")
    public ResponseEntity<?> getStore(@RequestHeader HttpHeaders headers) {
        List<StoreEntity> result = storeService.getAllStoreList();
        //long pk, String name, String note
        List<Store> resp = result.stream().map(entity -> new Store(entity.getPk(), entity.getName(), entity.getNote())).collect(Collectors.toList());
        ResponseResult respPage = new ResponseResult();
        respPage.setResult(resp);
        return new ResponseEntity(respPage, HttpStatus.OK);
    }

    @PostMapping(value = "/store")
    public ResponseEntity<?> addStore(@RequestHeader HttpHeaders headers,
                                      @RequestBody Store store) {
        StoreEntity entity = new StoreEntity();
        entity.setName(store.getName());
        entity.setNote(store.getNote());
        entity.setUrl(store.getUrl());
        StoreEntity result = storeService.addStoreEntity(entity);
        //long pk, String name, String note
        Store resp = new Store(entity.getPk(), entity.getName(), entity.getNote());
        ResponseResult respBean = new ResponseResult();
        respBean.setResult(Stream.of(resp).collect(Collectors.toList()));
        return new ResponseEntity(respBean, HttpStatus.OK);
    }

    @DeleteMapping(value = "/store/{pk}")
    public ResponseEntity<?> deleteStore(@RequestHeader HttpHeaders headers,
                                      @PathVariable("pk") long pk) {
        StoreEntity entity = storeService.deleteStoreEntity(pk);
        //long pk, String name, String note
        Store resp = new Store(entity.getPk(), entity.getName(), entity.getNote());
        ResponseResult respBean = new ResponseResult();
        respBean.setResult(resp);
        return new ResponseEntity(respBean, HttpStatus.OK);
    }

    @PutMapping(value = "/store")
    public ResponseEntity<?> deleteStore(@RequestHeader HttpHeaders headers,
                                         @RequestBody Store storeInfo) {
        StoreEntity entity = new StoreEntity();
        entity.setName(storeInfo.getName());
        entity.setNote(storeInfo.getNote());
        entity.setUrl(storeInfo.getUrl());
        StoreEntity result = storeService.updateStoreEntity(entity);
        //long pk, String name, String note
        Store resp = new Store(entity.getPk(), entity.getName(), entity.getNote());
        ResponseResult respBean = new ResponseResult();
        respBean.setResult(resp);
        return new ResponseEntity(respBean, HttpStatus.OK);
    }

}
