package com.oyl.cics.model.kjhuayandan;

import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.kjhuayandan.request.SearchCondition;
import com.oyl.cics.model.kjhuayandan.response.SearchResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;

@Component
public class KjhuayandanRepos {
    @Resource
    private KjhuayandanDao kjhuayandanDao;

    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = kjhuayandanDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(kjhuayandanDao.search(searchCondition));
        }

        return result;
    }
}
