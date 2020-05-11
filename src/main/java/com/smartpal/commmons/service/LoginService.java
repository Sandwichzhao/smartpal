package com.smartpal.commmons.service;

import com.smartpal.commmons.domain.UserEntity;
import com.smartpal.commmons.dto.LoginDto;

public interface LoginService {
    UserEntity loginInfo(LoginDto dto);
}
