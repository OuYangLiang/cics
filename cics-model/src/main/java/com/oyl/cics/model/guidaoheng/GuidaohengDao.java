package com.oyl.cics.model.guidaoheng;


import com.oyl.cics.model.guidaoheng.request.SearchCondition;

import java.util.List;

public interface GuidaohengDao {
    List<Guidaoheng> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    void uploadSucc(List<Guidaoheng> guidaohengs, String operator);

    void uploadFailed(List<Guidaoheng> guidaohengs, String operator);
}
