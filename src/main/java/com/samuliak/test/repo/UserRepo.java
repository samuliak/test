package com.samuliak.test.repo;

import com.samuliak.test.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;

public interface UserRepo extends CrudRepository<UserEntity, BigDecimal> {

    UserEntity findFirstByIdOrFio(BigDecimal id, String fio);

}
