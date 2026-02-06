package com.employee.demoemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import java.util.Objects;

@Data
@Embeddable
public class AccessesBelogingPK {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id")
    private ModuleEntity module;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccessesBelogingPK that = (AccessesBelogingPK) o;
        return Objects.equals(employee, that.employee) && Objects.equals(module, that.module);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, module);
    }
}
