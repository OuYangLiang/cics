package com.oyl.cics.impl.pidaimeicaiyang;

import com.oyl.cics.model.pidaimeicaiyang.Pidaimeicaiyang;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangDao;
import com.oyl.cics.model.pidaimeicaiyang.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PidaimeicaiyangDaoImpl implements PidaimeicaiyangDao {

    @Resource
    private PidaimeicaiyangMapper pidaimeicaiyangMapper;
    @Override
    public List<Pidaimeicaiyang> search(SearchCondition condition) {
        List<Pidaimeicaiyang> result = pidaimeicaiyangMapper.search(condition);

        if (null != result) {
            for (Pidaimeicaiyang pidaimeicaiyang : result) {
                pidaimeicaiyang.setDtCydy(pidaimeicaiyangMapper.queryDetails(pidaimeicaiyang.getMybs()));
            }
        }

        return result;
    }

    @Override
    public int numOf(SearchCondition condition) {
        return pidaimeicaiyangMapper.numOf(condition);
    }
}
