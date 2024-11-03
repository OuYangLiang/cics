package com.oyl.cics.model.pidaimeicaiyang;

import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.pidaimeicaiyang.request.SearchCondition;
import com.oyl.cics.model.pidaimeicaiyang.response.SearchResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;

@Component
public class PidaimeicaiyangRepos {
    @Resource
    private PidaimeicaiyangDao pidaimeicaiyangDao;

    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = pidaimeicaiyangDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(pidaimeicaiyangDao.search(searchCondition));
        }

        return result;
    }
}
