package com.oyl.cics.model.meicaiyang;

import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.meicaiyang.request.SearchCondition;
import com.oyl.cics.model.meicaiyang.response.SearchResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Component
public class MeicaiyangRepos {
    @Resource
    private MeicaiyangDao meicaiyangDao;

    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = meicaiyangDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(meicaiyangDao.search(searchCondition));
        }

        return result;
    }

    public List<Meicaiyang> queryByKeys(long[] ids) {
        return meicaiyangDao.queryByKeys(ids);
    }
}
