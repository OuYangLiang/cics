package com.oyl.cics.web.employee;

import com.oyl.cics.model.employee.EmployeeRepos;
import com.oyl.cics.model.employee.request.SearchCondition;
import com.oyl.cics.model.employee.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Resource
    private EmployeeRepos employeeRepos;

    @PostMapping("/employee/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(employeeRepos.search(condition));
    }
}
