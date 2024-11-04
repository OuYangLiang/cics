package com.oyl.cics.impl.meizhi;

import com.oyl.cics.model.meizhi.Meizhi;
import com.oyl.cics.model.meizhi.MeizhiDetail;
import com.oyl.cics.model.meizhi.request.SearchCondition;

import java.util.List;

public interface MeizhiMapper {
    List<Meizhi> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<MeizhiDetail> queryDetails(String mybs);

    List<Meizhi> queryByKeys(long[] ids);
}
