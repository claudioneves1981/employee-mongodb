package com.employee.demoemployee.service;

import com.employee.demoemployee.entity.ModuleEntity;
import com.employee.demoemployee.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;

    public List<ModuleEntity> getAllParametrized(){
        return moduleRepository.findAllParametrized();
    }
}
