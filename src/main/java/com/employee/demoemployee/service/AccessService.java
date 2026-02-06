package com.employee.demoemployee.service;

import com.employee.demoemployee.entity.*;
import com.employee.demoemployee.repository.AccessRepository;
import com.employee.demoemployee.repository.EmployeeRepository;
import com.employee.demoemployee.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessService {

    private final AccessRepository accessRepository;

    private final EmployeeRepository employeeRepository;

    private final ModuleRepository moduleRepository;

    public void create(EmployeeEntity employee, ModuleEntity module){

        AccessesBelogingPK accessesBelogingPK = new AccessesBelogingPK();

        //Optional<EmployeeEntity> employee = employeeRepository.findById(employee_id);
        //Optional<ModuleEntity> module = moduleRepository.findById(module_id);

        //employeeRepository.save(employee);
        //moduleRepository.save(module);
        //List<EmployeeEntity> employees = new ArrayList<>();
        //employees.add(employee);
       // module.setEmployees(employees);


        //ContactEntity contact = new ContactEntity();
        //contact.setEmployee(employee);

        //moduleRepository.save(module);


        accessesBelogingPK.setEmployee(employee);
        accessesBelogingPK.setModule(module);


        AccessEntity access = new AccessEntity();

        access.setId(accessesBelogingPK);
        access.setCreateData(false);
        access.setReadData(false);
        access.setUpdateData(false);
        access.setDeleteData(false);


        accessRepository.save(access);




    }

    public void update(AccessEntity access){

        accessRepository.update(access.isReadData(),
                access.isDeleteData(),
                access.isCreateData(),
                access.isUpdateData(),
                access.getId().getEmployee().getId(),
                access.getId().getModule().getId());

    }

}
