package com.oyl.cics.impl.kjhuayandan;


import com.oyl.cics.model.kjhuayandan.Kjhuayandan;

import java.util.List;

public interface KjhuayandanOracleMapper {
    List<Kjhuayandan> queryRecentRecords();
}
