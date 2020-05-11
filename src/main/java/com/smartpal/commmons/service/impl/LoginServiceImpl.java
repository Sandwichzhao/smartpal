package com.smartpal.commmons.service.impl;

import com.smartpal.commmons.domain.UserEntity;
import com.smartpal.commmons.dto.LoginDto;
import com.smartpal.commmons.service.LoginService;
import com.smartpal.commmons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public UserEntity loginInfo(LoginDto dto) {
        return userService.findEntityByLoginInfo(dto);
    }
}
