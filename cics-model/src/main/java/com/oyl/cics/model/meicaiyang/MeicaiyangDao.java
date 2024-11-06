package com.oyl.cics.model.meicaiyang;

import com.oyl.cics.model.meicaiyang.request.SearchCondition;

import java.util.List;

public interface MeicaiyangDao {
    List<Meicaiyang> search(SearchCondition condition);

    int numOf(SearchCondition condition);

    List<Meicaiyang> queryByKeys(long[] ids);

    void uploadSucc(List<Meicaiyang> meicaiyangs, String operator);

    void uploadFailed(List<Meicaiyang> meicaiyangs, String operator);

    List<Meicaiyang> queryRecentRecords();

    void override(Meicaiyang meicaiyang);
}
