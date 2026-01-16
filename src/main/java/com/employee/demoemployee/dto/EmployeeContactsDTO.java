package com.employee.demoemployee.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class EmployeeContactsDTO {

    private long employee_id;
    private String name;
    private BigDecimal salary;
    private OffsetDateTime birthday;
    private long contact_id;
    private String description;
    private String type;

}
