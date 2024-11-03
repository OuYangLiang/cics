package com.oyl.cics.model.pidaimeicaiyang;

import com.oyl.cics.model.pidaimeicaiyang.request.SearchCondition;

import java.util.List;

public interface PidaimeicaiyangDao {
    List<Pidaimeicaiyang> search(SearchCondition condition);

    int numOf(SearchCondition condition);
}
