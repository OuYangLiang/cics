package com.oyl.cics.model.huayandan;

import com.oyl.cics.model.huayandan.request.SearchCondition;

import java.util.List;

public interface HuayandanDao {
    List<Huayandan> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Huayandan> queryByKeys(long[] ids);

    void uploadSucc(List<Huayandan> huayandans, String operator);

    void uploadFailed(List<Huayandan> huayandans, String operator);

    List<Huayandan> queryRecentRecords();

    void override(Huayandan huayandan);

    List<Huayandan> queryForAutoUpload();
}
