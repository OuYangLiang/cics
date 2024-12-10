package com.oyl.cics.impl.qichecheng;

import com.oyl.cics.model.qichecheng.Qichecheng;
import com.oyl.cics.model.qichecheng.QichechengDetail;
import com.oyl.cics.model.qichecheng.request.SearchCondition;

import java.util.List;

public interface QichechengMapper {
    List<Qichecheng> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<QichechengDetail> queryDetails(String zmxdocNo);

    List<Qichecheng> queryByKeys(long[] ids);

    void uploadSucc(List<Qichecheng> qichechengs, String operator);

    void uploadFailed(List<Qichecheng> qichechengs, String operator);

    void removeDetails(String zmxdocNo);

    void addDetail(QichechengDetail detail);

    void override(Qichecheng qichecheng);

    List<Qichecheng> queryForAutoUpload();
}
