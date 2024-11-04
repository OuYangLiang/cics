package com.oyl.cics.impl.pidaimeicaiyang;

import com.oyl.cics.model.pidaimeicaiyang.Pidaimeicaiyang;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangDetail;
import com.oyl.cics.model.pidaimeicaiyang.request.SearchCondition;

import java.util.List;

public interface PidaimeicaiyangMapper {
    List<Pidaimeicaiyang> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<PidaimeicaiyangDetail> queryDetails(String mybs);

    List<Pidaimeicaiyang> queryByKeys(long[] ids);

    void uploadSucc(List<Pidaimeicaiyang> pidaimeicaiyangs, String operator);

    void uploadFailed(List<Pidaimeicaiyang> pidaimeicaiyangs, String operator);
}
