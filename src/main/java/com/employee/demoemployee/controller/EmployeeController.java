package com.employee.demoemployee.controller;

import java.util.List;
import java.util.Optional;

import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getById(@PathVariable Long id) {
        Optional<EmployeeEntity> employee = employeeService.getById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
            return ResponseEntity.ok(employeeService.getAll(pageNumber, pageSize));
    }

    @GetMapping("/order-by-name")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployeesByName(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(employeeService.getAllByName(pageNumber, pageSize));
    }

    @PostMapping
    public ResponseEntity<EmployeeEntity> create(@RequestBody EmployeeEntity employee) {
        employeeService.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping
    public ResponseEntity<EmployeeEntity> update(@RequestBody EmployeeEntity employee) {
        EmployeeEntity updatedEmployee = employeeService.update(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<EmployeeEntity> employee = employeeService.getById(id);
        if (employee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("No employee matches ID " + id);
        }
        employeeService.delete(id);
        return (ResponseEntity.ok("Employee with ID " + id + " was deleted."));
    }
}