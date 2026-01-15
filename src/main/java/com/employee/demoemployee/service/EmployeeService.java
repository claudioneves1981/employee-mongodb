package com.employee.demoemployee.service;
import java.util.List;
import java.util.Optional;

import com.employee.demoemployee.entity.AccessEntity;
import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.entity.ModuleEntity;
import com.employee.demoemployee.repository.AccessRepository;
import com.employee.demoemployee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final AccessService accessService;

    public Optional<EmployeeEntity> getById(Long id) {
        return employeeRepository.findById(id);
    }

    public EmployeeEntity getByIdParametrized(Long id) {
        return employeeRepository.findByIdParametrized(id);
    }

    public List<EmployeeEntity> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeRepository.findAll(pageable).getContent();
    }

    public EmployeeEntity create(EmployeeEntity employee) {

        employee.getModules().stream()
                .map(ModuleEntity::getId)
                .forEach(m -> accessService.create(employee.getId(),m));

        return employeeRepository.save(employee);
    }

    public EmployeeEntity update(EmployeeEntity employee) {
        return employeeRepository.updateEmployee(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}