package com.employee.demoemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "modules",
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
    })
    @JsonIgnore
    private List<EmployeeEntity> employees;

}
