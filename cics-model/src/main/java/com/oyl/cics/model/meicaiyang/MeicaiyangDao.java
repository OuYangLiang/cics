package com.oyl.cics.model.meicaiyang;

import com.oyl.cics.model.meicaiyang.request.SearchCondition;

import java.util.List;

public interface MeicaiyangDao {
    List<Meicaiyang> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Meicaiyang> queryByKeys(long[] ids);
}
