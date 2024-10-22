package com.oyl.cics.impl.guidaoheng;

import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengDao;
import com.oyl.cics.model.guidaoheng.GuidaohengDetail;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class GuidaohengDaoImpl implements GuidaohengDao {

    private static final Logger log = LoggerFactory.getLogger(GuidaohengDaoImpl.class);

    @Resource
    private GuidaohengMapper guidaohengMapper;

    @Resource
    private GuidaohengOracleMapper guidaohengOracleMapper;

    @Override
    public List<Guidaoheng> search(SearchCondition condition) {
        List<Guidaoheng> result = guidaohengMapper.search(condition);

        if (null != result) {
            for (Guidaoheng guidaoheng : result) {
                guidaoheng.setDtData(guidaohengMapper.queryDetails(guidaoheng.getZmxdocNo()));
            }
        }

        return result;
    }

    @Override
    public int numOf(SearchCondition condition) {
        return guidaohengMapper.numOf(condition);
    }

    @Override
    public void uploadSucc(List<Guidaoheng> guidaohengs, String operator) {
        guidaohengMapper.uploadSucc(guidaohengs, operator);
    }

    @Override
    public void uploadFailed(List<Guidaoheng> guidaohengs, String operator) {
        guidaohengMapper.uploadFailed(guidaohengs, operator);
    }

    @Override
    public List<Guidaoheng> queryByKeys(long[] ids) {
        List<Guidaoheng> result = guidaohengMapper.queryByKeys(ids);
        if (null != result) {
            for (Guidaoheng guidaoheng : result) {
                guidaoheng.setDtData(guidaohengMapper.queryDetails(guidaoheng.getZmxdocNo()));
            }
        }

        return result;
    }

    @Override
    public List<Guidaoheng> queryRecentRecords(int recentDays) {
        List<Guidaoheng> list = guidaohengOracleMapper.queryRecentRecords(recentDays);

        if (null == list || list.isEmpty()) {
            return Collections.emptyList();
        }

        for (Guidaoheng item : list) {
            if (null == item.getZmxdocNo() || item.getZmxdocNo().trim().isEmpty()) {
                continue;
            }
            List<GuidaohengDetail> details = guidaohengOracleMapper.queryDetails(item.getZmxdocNo());
            item.setDtData(null == details ? Collections.emptyList() : details);
        }

        return list;
    }
}
