package com.oyl.cics.impl.guidaoheng;

import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengDetail;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;

import java.util.List;

public interface GuidaohengMapper {
    List<Guidaoheng> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<GuidaohengDetail> queryDetails(String zmxdocNo);

    void uploadSucc(List<Guidaoheng> guidaoheng, String operator);

    void uploadFailed(List<Guidaoheng> guidaohengs, String operator);

    List<Guidaoheng> queryByKeys(long[] ids);

    void removeDetails(String zmxdocNo);

    void addDetail(GuidaohengDetail detail);

    void override(Guidaoheng guidaoheng);
}
