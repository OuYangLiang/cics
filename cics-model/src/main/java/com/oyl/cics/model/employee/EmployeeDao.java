package com.oyl.cics.model.employee;


import com.oyl.cics.model.employee.request.SearchCondition;

import java.util.List;

public interface EmployeeDao {
    List<Employee> search(SearchCondition condition);

    int numOf(SearchCondition condition);
}
