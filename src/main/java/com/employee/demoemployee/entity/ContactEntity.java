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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "employees",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id") )
    private EmployeeEntity employee;

}
