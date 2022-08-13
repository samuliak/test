package com.samuliak.test.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samuliak.test.common.exception.ObjectNotFoundException;
import com.samuliak.test.model.dto.UserDTO;
import com.samuliak.test.model.entity.UserEntity;
import com.samuliak.test.repo.UserRepo;
import com.samuliak.test.service.UserService;
import com.samuliak.test.utils.AesCryptUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Log4j2(topic = "FileLogger")
public class UserServiceImpl implements UserService {

    @Autowired
    private AesCryptUtils aesCryptUtils;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity getUserByParams(UserDTO userDTO) throws Exception {
        var encryptUserDTO = aesCryptUtils.encrypt(userDTO.toString());

        log.debug("Request params: ID - {}, fio - {}", userDTO.getId(), userDTO.getFio());
        log.debug("Request encryption params - {}", encryptUserDTO);
        log.debug("Request decryption params - {}", aesCryptUtils.decrypt(encryptUserDTO));

        var userEntity = userRepo.findFirstByIdOrFio(userDTO.getId(), userDTO.getFio());
        if (Objects.isNull(userEntity)) {
            throw new ObjectNotFoundException("null");
        }

        var encryptUser = aesCryptUtils.encrypt(userEntity.toString());
        var decryptUser = aesCryptUtils.decrypt(encryptUser);

        log.debug("Response encryption user - {}", encryptUser);
        log.debug("Response decryption user - {}", decryptUser);

        return new ObjectMapper().readValue(decryptUser, UserEntity.class);
    }

}
