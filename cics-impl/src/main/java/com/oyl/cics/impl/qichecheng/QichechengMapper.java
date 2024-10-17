package com.oyl.cics.impl.qichecheng;

import com.oyl.cics.model.qichecheng.Qichecheng;
import com.oyl.cics.model.qichecheng.QichechengDetail;
import com.oyl.cics.model.qichecheng.request.SearchCondition;

import java.util.List;

public interface QichechengMapper {
    List<Qichecheng> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<QichechengDetail> queryDetails(String zmxdocNo);
}
