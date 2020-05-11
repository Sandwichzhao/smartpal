package com.smartpal.commmons.controller;

import com.smartpal.common.ResponseResult;
import com.smartpal.commmons.domain.UserEntity;
import com.smartpal.commmons.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用户信息
 */
@Controller
@RequestMapping(value = "/v1")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(value = "user/info/{userId}")
    public ResponseEntity getUserInfo(@RequestHeader HttpHeaders headers,
                                      @PathVariable(name = "userId") long userId) {
        UserEntity userEntity = userService.findEntityById(userId);

        ResponseResult<UserEntity> response = new ResponseResult();
        if (Objects.isNull(userEntity)) {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setResult(Collections.emptyList());
        } else {
            response.setStatusCode(HttpStatus.OK.value());
            response.setResult(Stream.of(userEntity).collect(Collectors.toList()));
        }
        return ResponseEntity.ok(response);
    }
}
