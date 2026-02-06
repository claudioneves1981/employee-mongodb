package com.employee.demoemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@EqualsAndHashCode
public class AccessesBelogingPK implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "module_id")
    private Long moduleId;

}
