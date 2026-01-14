package com.employee.demoemployee.repository;

import com.employee.demoemployee.entity.EmployeeEntity;

public interface CustomEmployeeRepository {
    EmployeeEntity updateEmployee(EmployeeEntity employee);
}