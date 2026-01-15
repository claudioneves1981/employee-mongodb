package com.employee.demoemployee.controller;

import com.employee.demoemployee.entity.AccessEntity;
import com.employee.demoemployee.service.AccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/accesses")
public class AccessController {

    private AccessService accessService;

    @PostMapping
    public ResponseEntity<AccessEntity> create(@RequestBody AccessEntity access) {
        accessService.create(access);
        return ResponseEntity.status(HttpStatus.CREATED).body(access);
    }

}
