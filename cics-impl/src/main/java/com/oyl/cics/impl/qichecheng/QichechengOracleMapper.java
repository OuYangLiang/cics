package com.oyl.cics.impl.qichecheng;


import com.oyl.cics.model.qichecheng.Qichecheng;
import com.oyl.cics.model.qichecheng.QichechengDetail;

import java.util.List;

public interface QichechengOracleMapper {
    List<Qichecheng> queryRecentRecords();

    List<QichechengDetail> queryDetails(String zmxdocNo);
}
