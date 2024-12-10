package com.oyl.cics.impl.meicaiyang;

import com.oyl.cics.model.meicaiyang.Meicaiyang;
import com.oyl.cics.model.meicaiyang.MeicaiyangDao;
import com.oyl.cics.model.meicaiyang.MeicaiyangDetail;
import com.oyl.cics.model.meicaiyang.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class MeicaiyangDaoImpl implements MeicaiyangDao {

    @Resource
    private MeicaiyangMapper meicaiyangMapper;

    @Resource
    private MeicaiyangOracleMapper meicaiyangOracleMapper;

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

    @Override
    public void uploadSucc(List<Meicaiyang> meicaiyangs, String operator) {
        meicaiyangMapper.uploadSucc(meicaiyangs, operator);
    }

    @Override
    public void uploadFailed(List<Meicaiyang> meicaiyangs, String operator) {
        meicaiyangMapper.uploadFailed(meicaiyangs, operator);
    }

    @Override
    public void override(Meicaiyang meicaiyang) {
        meicaiyangMapper.removeDetails(meicaiyang.getMybs());
        for (MeicaiyangDetail detail : meicaiyang.getDtCydy()) {
            meicaiyangMapper.addDetail(detail);
        }

        meicaiyangMapper.override(meicaiyang);
    }

    @Override
    public List<Meicaiyang> queryForAutoUpload() {
        List<Meicaiyang> result = meicaiyangMapper.queryForAutoUpload();
        if (null != result) {
            for (Meicaiyang item : result) {
                item.setDtCydy(meicaiyangMapper.queryDetails(item.getMybs()));
            }
        }
        return result;
    }

    @Override
    public List<Meicaiyang> queryRecentRecords() {
        List<Meicaiyang> list = meicaiyangOracleMapper.queryRecentRecords();

        if (null == list || list.isEmpty()) {
            return Collections.emptyList();
        }

        for (Meicaiyang item : list) {
            if (null == item.getMybs() || item.getMybs().trim().isEmpty()) {
                continue;
            }
            List<MeicaiyangDetail> details = meicaiyangOracleMapper.queryDetails(item.getMybs());
            item.setDtCydy(null == details ? Collections.emptyList() : details);
        }

        return list;
    }
}
