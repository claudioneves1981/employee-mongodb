package com.employee.demoemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
@Entity(name="employees")
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private BigDecimal salary;
    private OffsetDateTime birthday;

    @OneToMany(fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<ContactEntity> contacts;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "accesses",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id"))
    private List<ModuleEntity> modules;

    public void addModuleEnitity(ModuleEntity module) {
        modules.add(module);
    }



}