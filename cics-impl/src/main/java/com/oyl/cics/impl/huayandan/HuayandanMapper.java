package com.oyl.cics.impl.huayandan;

import com.oyl.cics.model.huayandan.Huayandan;
import com.oyl.cics.model.huayandan.request.SearchCondition;

import java.util.List;

public interface HuayandanMapper {
    List<Huayandan> search(SearchCondition condition);

    int numOf(SearchCondition condition);
}
