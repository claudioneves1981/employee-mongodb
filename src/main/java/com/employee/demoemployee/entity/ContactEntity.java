package com.employee.demoemployee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="contacts")
public class ContactEntity {

    @Id
    private long id;

    private String description;

    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    private EmployeeEntity employee;

}
