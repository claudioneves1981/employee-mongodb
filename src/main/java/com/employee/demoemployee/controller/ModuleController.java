package com.employee.demoemployee.controller;

import com.employee.demoemployee.entity.ContactEntity;
import com.employee.demoemployee.entity.ModuleEntity;
import com.employee.demoemployee.repository.ModuleRepository;
import com.employee.demoemployee.service.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    @GetMapping
    public ResponseEntity<List<ModuleEntity>> getAll(){

        List<ModuleEntity> modules = moduleService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(modules);


    }

}
