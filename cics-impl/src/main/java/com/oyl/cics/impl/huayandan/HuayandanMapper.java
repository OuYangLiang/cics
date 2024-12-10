package com.oyl.cics.impl.huayandan;

import com.oyl.cics.model.huayandan.Huayandan;
import com.oyl.cics.model.huayandan.request.SearchCondition;
import com.oyl.cics.model.qichecheng.Qichecheng;
import com.oyl.cics.model.qichecheng.QichechengDetail;

import java.util.List;

public interface HuayandanMapper {
    List<Huayandan> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Huayandan> queryByKeys(long[] ids);

    void uploadSucc(List<Huayandan> huayandans, String operator);

    void uploadFailed(List<Huayandan> huayandans, String operator);

    void override(Huayandan huayandan);

    List<Huayandan> queryForAutoUpload();
}
