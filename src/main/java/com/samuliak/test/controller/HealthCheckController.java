package com.samuliak.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/check")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<?> healthCheck() {

        return ok("Hello world!");
    }

}
