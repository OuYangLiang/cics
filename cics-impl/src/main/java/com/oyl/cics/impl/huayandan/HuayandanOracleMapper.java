package com.oyl.cics.impl.huayandan;

import com.oyl.cics.model.huayandan.Huayandan;

import java.util.List;

public interface HuayandanOracleMapper {
    List<Huayandan> queryRecentRecords();
}
