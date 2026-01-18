package com.employee.demoemployee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity(name="contacts")
@Table(name="contacts")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String description;

    private String type;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

}
