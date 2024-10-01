package com.oyl.cics.model.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Long id;
    private String phone;
    private String employeeName;
    private String department;
    private Long salary;
}
