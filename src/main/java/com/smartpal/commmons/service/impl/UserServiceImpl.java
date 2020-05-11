package com.smartpal.commmons.service.impl;

import com.smartpal.commmons.domain.UserEntity;
import com.smartpal.commmons.domain.repository.UserRepository;
import com.smartpal.commmons.dto.LoginDto;
import com.smartpal.commmons.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findEntityById(long userId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        return userOptional.isPresent() ? userOptional.get() : userOptional.orElse(null);
    }

    @Override
    public UserEntity findEntityByLoginInfo(LoginDto loginDto) {
        Optional<UserEntity> userOptional = userRepository.findByAccountAndPassword(loginDto.getAccount(), loginDto.getPassword());
        return userOptional.isPresent() ? userOptional.get() : userOptional.orElse(null);
    }
}
