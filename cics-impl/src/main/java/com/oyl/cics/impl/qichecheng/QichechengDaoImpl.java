package com.oyl.cics.impl.qichecheng;

import com.oyl.cics.model.qichecheng.Qichecheng;
import com.oyl.cics.model.qichecheng.QichechengDao;
import com.oyl.cics.model.qichecheng.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class QichechengDaoImpl implements QichechengDao {

    @Resource
    private QichechengMapper qichechengMapper;

    @Override
    public List<Qichecheng> search(SearchCondition condition) {
        List<Qichecheng> result = qichechengMapper.search(condition);

        if (null != result) {
            for (Qichecheng qichecheng : result) {
                qichecheng.setDtData(qichechengMapper.queryDetails(qichecheng.getZmxdocNo()));
            }
        }

        return result;
    }

    @Override
    public int numOf(SearchCondition condition) {
        return qichechengMapper.numOf(condition);
    }

    @Override
    public List<Qichecheng> queryByKeys(long[] ids) {
        List<Qichecheng> result = qichechengMapper.queryByKeys(ids);
        if (null != result) {
            for (Qichecheng qichecheng : result) {
                qichecheng.setDtData(qichechengMapper.queryDetails(qichecheng.getZmxdocNo()));
            }
        }

        return result;
    }

    @Override
    public void uploadSucc(List<Qichecheng> qichechengs, String operator) {
        qichechengMapper.uploadSucc(qichechengs, operator);
    }

    @Override
    public void uploadFailed(List<Qichecheng> qichechengs, String operator) {
        qichechengMapper.uploadFailed(qichechengs, operator);
    }
}
