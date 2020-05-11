package com.smartpal.commmons.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/v1")
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "historyRecommend/filter")
    public ResponseEntity historyRecommendFilter(@RequestHeader HttpHeaders headers) {
        System.out.println("===============");

        return ResponseEntity.ok(null);
    }
}
