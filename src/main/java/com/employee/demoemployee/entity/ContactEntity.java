package com.employee.demoemployee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="contacts")
@Table(name="contacts")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String description;

    private String type;

    @ManyToOne
    @JoinTable(name = "employees",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id") )
    private EmployeeEntity employee;

}
