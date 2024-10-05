package com.oyl.cics.model.employee;

import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.employee.request.SearchCondition;
import com.oyl.cics.model.employee.response.SearchResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;

@Component
public class EmployeeRepos {
    @Resource
    private EmployeeDao employeeDao;

    /**
     * 根据条件搜索员工
     *
     * @param searchCondition 查询条件
     * @return SearchResult 员工集合
     */
    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = employeeDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(employeeDao.search(searchCondition));
        }

        return result;
    }
}
