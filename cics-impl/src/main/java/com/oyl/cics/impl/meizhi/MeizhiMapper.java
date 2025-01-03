package com.oyl.cics.impl.meizhi;

import com.oyl.cics.model.meizhi.Meizhi;
import com.oyl.cics.model.meizhi.MeizhiDetail;
import com.oyl.cics.model.meizhi.request.SearchCondition;

import java.util.List;

public interface MeizhiMapper {
    List<Meizhi> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    MeizhiDetail queryDetail(String mybs);

    List<Meizhi> queryByKeys(long[] ids);

    void uploadSucc(List<Meizhi> meizhis, String operator);

    void uploadFailed(List<Meizhi> meizhis, String operator);

    void removeDetail(String mybs);

    void addDetail(MeizhiDetail detail);

    void override(Meizhi meizhi);

    List<Meizhi> queryForAutoUpload();
}
