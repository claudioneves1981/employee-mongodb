package com.employee.demoemployee.controller;

import com.employee.demoemployee.entity.ContactEntity;
import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ContactEntity> create(@RequestBody ContactEntity contact) {
        contactService.create(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ContactEntity>> getByEmployeeId(@PathVariable Long id){
        List<ContactEntity> contacts = contactService.getByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(contacts);
    }

}
