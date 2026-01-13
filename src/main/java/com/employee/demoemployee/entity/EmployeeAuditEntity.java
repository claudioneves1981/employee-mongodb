package com.employee.demoemployee.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record EmployeeAuditEntity(
        long employeeId,
        String name,
        String oldName,
        BigDecimal salary,
        OffsetDateTime birthday,
        OffsetDateTime oldBirthday,
        OperationEnum operation
) {
}
