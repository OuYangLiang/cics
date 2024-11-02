package com.oyl.cics.model.qichecheng;

import com.oyl.cics.model.qichecheng.request.SearchCondition;

import java.util.List;

public interface QichechengDao {
    List<Qichecheng> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Qichecheng> queryByKeys(long[] ids);
}
