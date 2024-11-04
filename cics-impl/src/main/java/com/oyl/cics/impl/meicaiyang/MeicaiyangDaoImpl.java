package com.oyl.cics.impl.meicaiyang;

import com.oyl.cics.model.meicaiyang.Meicaiyang;
import com.oyl.cics.model.meicaiyang.MeicaiyangDao;
import com.oyl.cics.model.meicaiyang.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MeicaiyangDaoImpl implements MeicaiyangDao {

    @Resource
    private MeicaiyangMapper meicaiyangMapper;

    @Override
    public List<Meicaiyang> search(SearchCondition condition) {
        List<Meicaiyang> result = meicaiyangMapper.search(condition);

        if (null != result) {
            for (Meicaiyang meicaiyang : result) {
                meicaiyang.setDtCydy(meicaiyangMapper.queryDetails(meicaiyang.getMybs()));
            }
        }

        return result;
    }

    @Override
    public int numOf(SearchCondition condition) {
        return meicaiyangMapper.numOf(condition);
    }

    @Override
    public List<Meicaiyang> queryByKeys(long[] ids) {
        List<Meicaiyang> result = meicaiyangMapper.queryByKeys(ids);
        if (null != result) {
            for (Meicaiyang item : result) {
                item.setDtCydy(meicaiyangMapper.queryDetails(item.getMybs()));
            }
        }
        return result;
    }

}
