package com.oyl.cics.impl.meicaiyang;

import com.oyl.cics.model.meicaiyang.Meicaiyang;
import com.oyl.cics.model.meicaiyang.MeicaiyangDetail;

import java.util.List;

public interface MeicaiyangOracleMapper {
    List<Meicaiyang> queryRecentRecords();

    List<MeicaiyangDetail> queryDetails(String mybs);
}
