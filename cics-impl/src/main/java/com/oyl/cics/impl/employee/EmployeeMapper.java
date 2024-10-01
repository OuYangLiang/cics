package com.oyl.cics.impl.employee;

import com.oyl.cics.model.employee.Employee;
import com.oyl.cics.model.employee.request.SearchCondition;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> search(SearchCondition condition);

    int numOf(SearchCondition condition);
}
