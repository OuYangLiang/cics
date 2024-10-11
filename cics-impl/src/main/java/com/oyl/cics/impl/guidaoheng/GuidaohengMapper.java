package com.oyl.cics.impl.guidaoheng;

import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;

import java.util.List;

public interface GuidaohengMapper {
    List<Guidaoheng> search(SearchCondition condition);

    int numOf(SearchCondition condition);
}
