package com.oyl.cics.model.meizhi;

import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.meizhi.request.SearchCondition;
import com.oyl.cics.model.meizhi.response.SearchResult;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Configuration
public class MeizhiRepos {
    @Resource
    private MeizhiDao meizhiDao;

    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = meizhiDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(meizhiDao.search(searchCondition));
        }

        return result;
    }

    public List<Meizhi> queryByKeys(long[] ids) {
        return meizhiDao.queryByKeys(ids);
    }

    public List<Meizhi> queryFromOldSystem() {
        return meizhiDao.queryRecentRecords();
    }
}
