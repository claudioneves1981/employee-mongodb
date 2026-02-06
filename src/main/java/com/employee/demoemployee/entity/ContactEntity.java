package com.employee.demoemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    @ToString.Exclude
    private EmployeeEntity employee;

}
