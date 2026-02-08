package com.employee.demoemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name ="accesses")
@Table(name="accesses")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AccessEntity {

    @EmbeddedId
    private AccessesBelogingPK id = new AccessesBelogingPK();

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id", nullable = false)
    @JsonIgnore
    //@ToString.Exclude
    private EmployeeEntity employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("moduleId")
    @JoinColumn(name = "module_id", nullable = false)
    private ModuleEntity module;

    private boolean readData;

    private boolean deleteData;

    private boolean createData;

    private boolean updateData;

}
