package com.oyl.cics.model.pidaimeicaiyang;

import com.oyl.cics.model.pidaimeicaiyang.request.SearchCondition;

import java.util.List;

public interface PidaimeicaiyangDao {
    List<Pidaimeicaiyang> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Pidaimeicaiyang> queryByKeys(long[] ids);

    void uploadSucc(List<Pidaimeicaiyang> pidaimeicaiyangs, String operator);

    void uploadFailed(List<Pidaimeicaiyang> pidaimeicaiyangs, String operator);

    List<Pidaimeicaiyang> queryRecentRecords();

    void override(Pidaimeicaiyang pidaimeicaiyang);
}
