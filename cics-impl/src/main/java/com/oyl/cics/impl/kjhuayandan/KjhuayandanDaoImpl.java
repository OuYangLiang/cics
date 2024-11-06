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

//    @Resource
//    private KjhuayandanOracleMapper kjhuayandanOracleMapper;

    @Override
    public List<Kjhuayandan> search(SearchCondition condition) {
        return kjhuayandanMapper.search(condition);
    }

    @Override
    public int numOf(SearchCondition condition) {
        return kjhuayandanMapper.numOf(condition);
    }

    @Override
    public List<Kjhuayandan> queryByKeys(long[] ids) {
        return kjhuayandanMapper.queryByKeys(ids);
    }

    @Override
    public void uploadSucc(List<Kjhuayandan> kjhuayandans, String operator) {
        kjhuayandanMapper.uploadSucc(kjhuayandans, operator);
    }

    @Override
    public void uploadFailed(List<Kjhuayandan> kjhuayandans, String operator) {
        kjhuayandanMapper.uploadFailed(kjhuayandans, operator);
    }

    @Override
    public void override(Kjhuayandan kjhuayandan) {
        kjhuayandanMapper.override(kjhuayandan);
    }

    @Override
    public List<Kjhuayandan> queryRecentRecords() {
//        return kjhuayandanOracleMapper.queryRecentRecords();
        throw new IllegalStateException("Not Implemented");
    }
}
