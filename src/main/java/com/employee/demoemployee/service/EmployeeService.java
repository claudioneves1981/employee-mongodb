package com.employee.demoemployee.service;
import java.util.List;
import java.util.Optional;

import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<EmployeeEntity> getById(Long id) {
        return Optional.ofNullable(employeeRepository.findById(id));
    }

    public List<EmployeeEntity> getByFirstname(String firstname) {
        return employeeRepository.findByFirstname(firstname);
    }

    public List<EmployeeEntity> getByLastname(String lastname) {
        return employeeRepository.findByLastname(lastname);
    }

    public List<EmployeeEntity> getByFirstnameAndLastname(String firstname, String lastname) {
        return employeeRepository.findByFirstnameAndLastName(firstname, lastname);
    }

    public Optional<EmployeeEntity> getByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<EmployeeEntity> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeRepository.findAll(pageable).getContent();
    }

    public EmployeeEntity create(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeEntity update(EmployeeEntity employee) {
        return employeeRepository.updateEmployee(employee);
    }

    public void delete(String id) {
        employeeRepository.deleteById(id);
    }
}