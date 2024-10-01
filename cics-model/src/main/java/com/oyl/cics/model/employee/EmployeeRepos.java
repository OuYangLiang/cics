package com.oyl.cics.model.employee;

import com.oyl.cics.model.employee.request.SearchCondition;
import com.oyl.cics.model.employee.response.SearchResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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
    public SearchResult search(SearchCondition searchCondition) {
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
