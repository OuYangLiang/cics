package com.oyl.cics.model.meizhi;

import com.oyl.cics.model.meizhi.request.SearchCondition;

import java.util.List;

public interface MeizhiDao {
    List<Meizhi> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Meizhi> queryByKeys(long[] ids);

    void uploadSucc(List<Meizhi> meizhis, String operator);

    void uploadFailed(List<Meizhi> meizhis, String operator);

    List<Meizhi> queryRecentRecords();

    void override(Meizhi meizhi);
}
