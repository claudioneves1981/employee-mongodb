package com.employee.demoemployee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity
@Table(name="employees")
public class EmployeeEntity {

    @Id
    private Long id;

    private String name;
    private BigDecimal salary;
    private OffsetDateTime birthday;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ContactEntity> contacts;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<ModuleEntity> modules;

}