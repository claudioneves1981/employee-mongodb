package com.employee.demoemployee.controller;

import com.employee.demoemployee.entity.AccessEntity;
import com.employee.demoemployee.service.AccessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/accesses")
@RequiredArgsConstructor
public class AccessController {

    private AccessService accessService;

    @PostMapping
    public ResponseEntity<AccessEntity> create(@RequestBody AccessEntity access) {
        accessService.create(access.getId().getEmployee(), access.getId().getModule());
        return ResponseEntity.status(HttpStatus.CREATED).body(access);
    }

    @PutMapping
    public ResponseEntity<AccessEntity> update(@RequestBody AccessEntity access) {
        accessService.update(access);
        return ResponseEntity.status(HttpStatus.CREATED).body(access);
    }



}
