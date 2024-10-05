package com.oyl.cics.model.employee.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class SearchCondition {
    @Min(value = 1, message = "请求页最小1")
    private int page = 1;
    
    @Min(value = 1, message = "分页大小最小为1")
    private int pageSize = 10;
    private String department;
    private String employeeNamePrefix;

    public int getOffset() {
        return (page - 1) * pageSize;
    }

}
