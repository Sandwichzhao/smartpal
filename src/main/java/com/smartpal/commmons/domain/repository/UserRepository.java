package com.smartpal.commmons.domain.repository;

import com.smartpal.commmons.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByAccountAndPassword(String account, String password);
}
