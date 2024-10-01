package com.oyl.cics.impl.employee;

import com.oyl.cics.model.employee.Employee;
import com.oyl.cics.model.employee.EmployeeDao;
import com.oyl.cics.model.employee.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> search(SearchCondition condition) {
        return employeeMapper.search(condition);
    }

    @Override
    public int numOf(SearchCondition condition) {
        return employeeMapper.numOf(condition);
    }
}
