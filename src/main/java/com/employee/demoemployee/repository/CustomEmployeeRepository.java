package com.employee.demoemployee.repository;

import com.employee.demoemployee.model.Employee;

public interface CustomEmployeeRepository {
    Employee updateEmployee(String id, Employee employee);
}