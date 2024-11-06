package com.oyl.cics.impl.pidaimeicaiyang;

import com.oyl.cics.model.pidaimeicaiyang.Pidaimeicaiyang;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangDetail;

import java.util.List;

public interface PidaimeicaiyangOracleMapper {
    List<Pidaimeicaiyang> queryRecentRecords();

    List<PidaimeicaiyangDetail> queryDetails(String mybs);
}
