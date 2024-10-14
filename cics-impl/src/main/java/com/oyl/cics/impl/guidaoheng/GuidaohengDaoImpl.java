package com.oyl.cics.impl.guidaoheng;

import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengDao;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class GuidaohengDaoImpl implements GuidaohengDao {

    @Resource
    private GuidaohengMapper guidaohengMapper;

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
}
