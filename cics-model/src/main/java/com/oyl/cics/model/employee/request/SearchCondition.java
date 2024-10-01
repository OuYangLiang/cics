package com.oyl.cics.model.employee.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCondition {
    private int page = 1;
    private int pageSize = 10;
    private String department;
    private String employeeNamePrefix;

    public int getOffset() {
        return (page - 1) * pageSize;
    }

}
