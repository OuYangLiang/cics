package com.oyl.cics.impl.kjhuayandan;

import com.oyl.cics.model.kjhuayandan.Kjhuayandan;
import com.oyl.cics.model.kjhuayandan.KjhuayandanDao;
import com.oyl.cics.model.kjhuayandan.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class KjhuayandanDaoImpl implements KjhuayandanDao {

    @Resource
    private KjhuayandanMapper kjhuayandanMapper;

    @Override
    public List<Kjhuayandan> search(SearchCondition condition) {
        return kjhuayandanMapper.search(condition);
    }

    @Override
    public int numOf(SearchCondition condition) {
        return kjhuayandanMapper.numOf(condition);
    }
}
