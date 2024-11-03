package com.oyl.cics.impl.huayandan;

import com.oyl.cics.model.huayandan.Huayandan;
import com.oyl.cics.model.huayandan.HuayandanDao;
import com.oyl.cics.model.huayandan.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HuayandanDaoImpl implements HuayandanDao {

    @Resource
    private HuayandanMapper huayandanMapper;

    @Override
    public List<Huayandan> search(SearchCondition condition) {
        return huayandanMapper.search(condition);
    }

    @Override
    public int numOf(SearchCondition condition) {
        return huayandanMapper.numOf(condition);
    }
}
