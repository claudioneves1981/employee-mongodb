package com.employee.demoemployee.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.employee.demoemployee.entity.*;
import com.employee.demoemployee.repository.ContactRepository;
import com.employee.demoemployee.repository.EmployeeRepository;
import com.employee.demoemployee.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModuleRepository moduleRepository;

    private final ContactRepository contactRepository;

    private final AccessService accessService;

    public Optional<EmployeeEntity> getById(Long id) {
        return employeeRepository.findById(id);
    }

    //public Optional<EmployeeEntity> getByIdParametrized(Long id) {
   //      return employeeRepository.findByIdParametrized(id);
   // }

    public List<EmployeeEntity> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeRepository.findAll(pageable).getContent();
    }

    public List<EmployeeEntity> getAllByName(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeRepository.findAllByOrderByName(pageable).getContent();
    }

    public void create(EmployeeEntity employee) {


        employee.getAccesses().stream()
                .map(AccessEntity::getId)
                .forEach(m-> accessService.create(employee.getId(),m.getModuleId()));



       employeeRepository.save(employee);

    }

    public EmployeeEntity update(EmployeeEntity employee) {

        EmployeeEntity updatedEmployee = new EmployeeEntity();

        if(employee.getId()!=null){
          updatedEmployee.setName(employee.getName());
          updatedEmployee.setSalary(employee.getSalary());
          updatedEmployee.setBirthday(employee.getBirthday());
          updatedEmployee.setId(employee.getId());
        }

        return employeeRepository.save(updatedEmployee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}