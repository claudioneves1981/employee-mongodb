package com.employee.demoemployee.service;
import java.util.List;
import java.util.Optional;

import com.employee.demoemployee.model.Employee;
import com.employee.demoemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getById(String id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getByFirstname(String firstname) {
        return employeeRepository.findByFirstname(firstname);
    }

    public List<Employee> getByLastname(String lastname) {
        return employeeRepository.findByLastname(lastname);
    }

    public List<Employee> getByFirstnameAndLastname(String firstname, String lastname) {
        return employeeRepository.findByFirstnameAndLastName(firstname, lastname);
    }

    public Optional<Employee> getByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeRepository.findAll(pageable).getContent();
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(String id, Employee employee) {
        return employeeRepository.updateEmployee(id, employee);
    }

    public void delete(String id) {
        employeeRepository.deleteById(id);
    }
}