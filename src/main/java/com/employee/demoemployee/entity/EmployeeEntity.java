package com.employee.demoemployee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity
public class EmployeeEntity {

    @Id
    private Long id;

    private String name;
    private BigDecimal salary;
    private OffsetDateTime birthday;
    private List<ContactEntity> contacts;
    private List<ModuleEntity> modules;

}