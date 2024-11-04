package com.oyl.cics.model.kjhuayandan;

import com.oyl.cics.model.kjhuayandan.request.SearchCondition;

import java.util.List;

public interface KjhuayandanDao {
    List<Kjhuayandan> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Kjhuayandan> queryByKeys(long[] ids);
}