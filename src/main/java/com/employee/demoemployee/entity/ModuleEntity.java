package com.employee.demoemployee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ModuleEntity {

    @Id
    private long id;

    private String name;

    private List<EmployeeEntity> employees;

}
