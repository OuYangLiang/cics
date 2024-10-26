package com.oyl.cics.impl.guidaoheng;


import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengDetail;

import java.util.List;

public interface GuidaohengOracleMapper {
    List<Guidaoheng> queryRecentRecords();

    List<GuidaohengDetail> queryDetails(String zmxdocNo);
}
