package com.samuliak.test.service;

import com.samuliak.test.model.dto.UserDTO;
import com.samuliak.test.model.entity.UserEntity;

public interface UserService {

    UserEntity getUserByParams(UserDTO userDTO) throws Exception;

}
