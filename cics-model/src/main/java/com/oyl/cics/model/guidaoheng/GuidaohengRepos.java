package com.oyl.cics.model.guidaoheng;

import com.oyl.cics.model.common.validation.ValidParam;
import com.oyl.cics.model.guidaoheng.response.SearchResult;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class GuidaohengRepos {

    @Resource
    private GuidaohengDao guidaohengDao;

    @ValidParam
    public SearchResult search(@Valid @NotNull(message = "查询对象不能为空") SearchCondition searchCondition) {
        int numOfRecords = guidaohengDao.numOf(searchCondition);

        SearchResult result = new SearchResult();
        result.setPage(searchCondition.getPage());
        result.setPageSize(searchCondition.getPageSize());
        result.setNumOfRecords(numOfRecords);

        if (( (searchCondition.getPage() - 1) * searchCondition.getPageSize()) >= numOfRecords) {
            result.setRecords(Collections.emptyList());
        } else {
            result.setRecords(guidaohengDao.search(searchCondition));
        }

        return result;
    }

    public List<Guidaoheng> queryByKeys(long[] ids) {
        return guidaohengDao.queryByKeys(ids);
    }

    public List<Guidaoheng> queryFromOldSystem() {
        return guidaohengDao.queryRecentRecords(thirtyDaysAgo());
    }

    private String thirtyDaysAgo() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR, -30);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(c.getTime());
    }
}
