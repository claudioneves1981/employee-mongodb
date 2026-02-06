package com.employee.demoemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name="modules")
@Table(name="modules")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "accesses",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    @JsonIgnore
    @ToString.Exclude
    private List<EmployeeEntity> employees;

    public void addEmployeeEnitity(EmployeeEntity employee) {
        employees.add(employee);
    }

}
