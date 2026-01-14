package com.employee.demoemployee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ContactEntity {

    @Id
    private long id;

    private String description;

    private String type;

    @ManyToOne
    //@JoinColumn(name = "employee_id" )
    private EmployeeEntity employee;

}
