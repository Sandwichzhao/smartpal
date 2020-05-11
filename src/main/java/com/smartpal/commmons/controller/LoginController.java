package com.smartpal.commmons.controller;

import com.smartpal.commmons.bean.LoginBean;
import com.smartpal.common.ResponseResult;
import com.smartpal.commmons.domain.UserEntity;
import com.smartpal.commmons.dto.LoginDto;
import com.smartpal.commmons.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 用户登录
 */
@Controller
@RequestMapping(value = "/v1")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "user/login")
    public ResponseEntity userLogin(@RequestHeader HttpHeaders headers,
                                    @RequestBody LoginBean loginBean) {

        UserEntity userEntity = loginService.loginInfo(new LoginDto(loginBean));

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

    @GetMapping(value = "user/login")
    public String getUserLogin(@RequestHeader HttpHeaders headers) {

        return "index";
    }


}
