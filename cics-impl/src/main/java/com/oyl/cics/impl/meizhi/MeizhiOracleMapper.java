package com.oyl.cics.impl.meizhi;

import com.oyl.cics.model.meizhi.Meizhi;
import com.oyl.cics.model.meizhi.MeizhiDetail;

import java.util.List;

public interface MeizhiOracleMapper {
    List<Meizhi> queryRecentRecords();

    MeizhiDetail queryDetail(String mybs);
}
