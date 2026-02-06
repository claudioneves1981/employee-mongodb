package com.employee.demoemployee.service;

import com.employee.demoemployee.entity.ModuleEntity;
import com.employee.demoemployee.repository.ModuleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;

    public List<ModuleEntity> getAll(){
        return moduleRepository.findAll();
    }
}
