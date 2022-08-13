package com.samuliak.test.controller;

import com.samuliak.test.model.dto.UserDTO;
import com.samuliak.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/test",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<?> getUserByParams(@RequestBody UserDTO userDTO) throws Exception {

        return ok(userService.getUserByParams(userDTO));
    }

}
