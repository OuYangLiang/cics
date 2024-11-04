package com.oyl.cics.model.huayandan;

import com.oyl.cics.model.huayandan.request.SearchCondition;

import java.util.List;

public interface HuayandanDao {
    List<Huayandan> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Huayandan> queryByKeys(long[] ids);
}
