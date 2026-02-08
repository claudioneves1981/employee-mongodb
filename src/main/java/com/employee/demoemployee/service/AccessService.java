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

    public void create(Long employee_id, Long module_id){

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

        //System.out.println(employee_id);

        accessesBelogingPK.setEmployeeId(employee_id);
        accessesBelogingPK.setModuleId(module_id);


        AccessEntity access = new AccessEntity();

        access.setId(accessesBelogingPK);
        //access.setModule(module.get());
        //access.setEmployee(employee.get());
        //access.setCreateData(false);
        //access.setReadData(false);
        //access.setUpdateData(false);
        //access.setDeleteData(false);

        accessRepository.save(access);


    }

    public void update(AccessEntity access) {

        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setReadData(access.isReadData());
        accessEntity.setDeleteData(access.isDeleteData());
        accessEntity.setCreateData(access.isCreateData());
        accessEntity.setUpdateData(access.isUpdateData());
        accessEntity.setId(access.getId());
    }


}
