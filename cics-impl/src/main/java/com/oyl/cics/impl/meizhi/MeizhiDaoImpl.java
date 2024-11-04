package com.oyl.cics.impl.meizhi;

import com.oyl.cics.model.meizhi.Meizhi;
import com.oyl.cics.model.meizhi.MeizhiDao;
import com.oyl.cics.model.meizhi.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class MeizhiDaoImpl implements MeizhiDao {

    @Resource
    private MeizhiMapper meizhiMapper;

    @Override
    public List<Meizhi> search(SearchCondition condition) {
        List<Meizhi> result = meizhiMapper.search(condition);

        if (null != result) {
            for (Meizhi meizhi : result) {
                meizhi.setDtHydbhxq(meizhiMapper.queryDetails(meizhi.getMybs()));
            }
        }

        return result;
    }

    @Override
    public int numOf(SearchCondition condition) {
        return meizhiMapper.numOf(condition);
    }

    @Override
    public List<Meizhi> queryByKeys(long[] ids) {
        List<Meizhi> result = meizhiMapper.queryByKeys(ids);
        if (null != result) {
            for (Meizhi item : result) {
                item.setDtHydbhxq(meizhiMapper.queryDetails(item.getMybs()));
            }
        }

        return result;
    }

    @Override
    public void uploadSucc(List<Meizhi> meizhis, String operator) {
        meizhiMapper.uploadSucc(meizhis, operator);
    }

    @Override
    public void uploadFailed(List<Meizhi> meizhis, String operator) {
        meizhiMapper.uploadFailed(meizhis, operator);
    }
}
