package com.oyl.cics.impl.huayandan;

import com.oyl.cics.model.huayandan.Huayandan;
import com.oyl.cics.model.huayandan.HuayandanDao;
import com.oyl.cics.model.huayandan.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class HuayandanDaoImpl implements HuayandanDao {

    @Resource
    private HuayandanMapper huayandanMapper;

    @Resource
    private HuayandanOracleMapper huayandanOracleMapper;

    @Override
    public List<Huayandan> search(SearchCondition condition) {
        return huayandanMapper.search(condition);
    }

    @Override
    public int numOf(SearchCondition condition) {
        return huayandanMapper.numOf(condition);
    }

    @Override
    public List<Huayandan> queryByKeys(long[] ids) {
        return huayandanMapper.queryByKeys(ids);
    }

    @Override
    public void uploadSucc(List<Huayandan> huayandans, String operator) {
        huayandanMapper.uploadSucc(huayandans, operator);
    }

    @Override
    public void uploadFailed(List<Huayandan> huayandans, String operator) {
        huayandanMapper.uploadFailed(huayandans, operator);
    }

    @Override
    public void override(Huayandan huayandan) {
        huayandanMapper.override(huayandan);
    }

    @Override
    public List<Huayandan> queryForAutoUpload() {
        return huayandanMapper.queryForAutoUpload();
    }

    @Override
    public List<Huayandan> queryRecentRecords() {
        return huayandanOracleMapper.queryRecentRecords();
    }
}
