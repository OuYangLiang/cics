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
import java.util.Comparator;
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
                List<GuidaohengDetail> details = guidaohengMapper.queryDetails(guidaoheng.getZmxdocNo());
                details.sort(new Comparator<GuidaohengDetail>() {
                    @Override
                    public int compare(GuidaohengDetail o1, GuidaohengDetail o2) {
                        return Integer.parseInt(o1.getDtSortno()) - Integer.parseInt(o2.getDtSortno());
                    }
                });
                guidaoheng.setDtData(details);
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
    public List<Guidaoheng> queryRecentRecords() {
        List<Guidaoheng> list = guidaohengOracleMapper.queryRecentRecords();

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

    @Override
    public void override(Guidaoheng guidaoheng) {
        guidaohengMapper.removeDetails(guidaoheng.getZmxdocNo());
        for (GuidaohengDetail detail : guidaoheng.getDtData()) {
            guidaohengMapper.addDetail(detail);
        }

        guidaohengMapper.override(guidaoheng);
    }
}
