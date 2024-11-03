package com.oyl.cics.impl.meicaiyang;

import com.oyl.cics.model.meicaiyang.Meicaiyang;
import com.oyl.cics.model.meicaiyang.MeicaiyangDetail;
import com.oyl.cics.model.meicaiyang.request.SearchCondition;

import java.util.List;

public interface MeicaiyangMapper {
    List<Meicaiyang> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<MeicaiyangDetail> queryDetails(String mybs);
}
