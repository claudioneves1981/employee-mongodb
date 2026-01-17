package com.employee.demoemployee.service;

import com.employee.demoemployee.entity.AccessEntity;
import com.employee.demoemployee.entity.AccessesBelogingPK;
import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.entity.ModuleEntity;
import com.employee.demoemployee.repository.AccessRepository;
import com.employee.demoemployee.repository.EmployeeRepository;
import com.employee.demoemployee.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessService {

    private final AccessRepository accessRepository;

    private final EmployeeRepository employeeRepository;

    private final ModuleRepository moduleRepository;

    public void create(Long employee_id, Long module_id){

        AccessesBelogingPK accessesBelogingPK = new AccessesBelogingPK();
        Optional<EmployeeEntity> employee = employeeRepository.findById(employee_id);
        Optional<ModuleEntity> module = moduleRepository.findById(module_id);
        accessesBelogingPK.setModule(module.get());
        accessesBelogingPK.setEmployee(employee.get());
        AccessEntity access = new AccessEntity();
        access.setId(accessesBelogingPK);

        accessRepository.save(access);

    }

}
