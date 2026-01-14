package com.employee.demoemployee.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Objects;

@Data
@Embeddable
public class AccessesBelogingPK {

    @ManyToOne
    private EmployeeEntity employee;

    @ManyToOne
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
