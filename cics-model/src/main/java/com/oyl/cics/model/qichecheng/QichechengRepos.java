package com.oyl.cics.model.qichecheng;

import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.qichecheng.request.SearchCondition;
import com.oyl.cics.model.qichecheng.response.SearchResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Component
public class QichechengRepos {

    @Resource
    private QichechengDao qichechengDao;

    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = qichechengDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(qichechengDao.search(searchCondition));
        }

        return result;
    }

    public List<Qichecheng> queryByKeys(long[] ids) {
        return qichechengDao.queryByKeys(ids);
    }

    public List<Qichecheng> queryFromOldSystem() {
        return qichechengDao.queryRecentRecords();
    }
}
