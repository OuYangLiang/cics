package com.oyl.cics.model.huayandan;

import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.huayandan.request.SearchCondition;
import com.oyl.cics.model.huayandan.response.SearchResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Component
public class HuayandanRepos {
    @Resource
    private HuayandanDao huayandanDao;

    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = huayandanDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(huayandanDao.search(searchCondition));
        }

        return result;
    }

    public List<Huayandan> queryByKeys(long[] ids) {
        return huayandanDao.queryByKeys(ids);
    }

    public List<Huayandan> queryFromOldSystem() {
        return huayandanDao.queryRecentRecords();
    }
}
