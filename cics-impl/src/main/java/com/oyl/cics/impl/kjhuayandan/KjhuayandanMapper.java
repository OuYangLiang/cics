package com.oyl.cics.impl.kjhuayandan;

import com.oyl.cics.model.kjhuayandan.Kjhuayandan;
import com.oyl.cics.model.kjhuayandan.request.SearchCondition;

import java.util.List;

public interface KjhuayandanMapper {
    List<Kjhuayandan> search(SearchCondition condition);

    int numOf(SearchCondition condition);
}
