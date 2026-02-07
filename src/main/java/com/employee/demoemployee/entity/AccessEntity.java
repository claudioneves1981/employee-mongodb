package com.employee.demoemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity(name ="accesses")
@Table(name="accesses")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AccessEntity {

    @EmbeddedId
    private AccessesBelogingPK id = new AccessesBelogingPK();

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private EmployeeEntity employee = new EmployeeEntity();

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId("moduleId")
    @JoinColumn(name = "module_id")
    private ModuleEntity module;

    private boolean readData;

    private boolean deleteData;

    private boolean createData;

    private boolean updateData;

}
