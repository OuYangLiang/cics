package com.oyl.cics.impl.pidaimeicaiyang;

import com.oyl.cics.model.pidaimeicaiyang.Pidaimeicaiyang;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangDao;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangDetail;
import com.oyl.cics.model.pidaimeicaiyang.request.SearchCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class PidaimeicaiyangDaoImpl implements PidaimeicaiyangDao {

    @Resource
    private PidaimeicaiyangMapper pidaimeicaiyangMapper;

    @Resource
    private PidaimeicaiyangOracleMapper pidaimeicaiyangOracleMapper;

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

    @Override
    public List<Pidaimeicaiyang> queryByKeys(long[] ids) {
        List<Pidaimeicaiyang> result = pidaimeicaiyangMapper.queryByKeys(ids);
        if (null != result) {
            for (Pidaimeicaiyang item : result) {
                item.setDtCydy(pidaimeicaiyangMapper.queryDetails(item.getMybs()));
            }
        }
        return result;
    }

    @Override
    public void uploadSucc(List<Pidaimeicaiyang> pidaimeicaiyangs, String operator) {
        pidaimeicaiyangMapper.uploadSucc(pidaimeicaiyangs, operator);
    }

    @Override
    public void uploadFailed(List<Pidaimeicaiyang> pidaimeicaiyangs, String operator) {
        pidaimeicaiyangMapper.uploadFailed(pidaimeicaiyangs, operator);
    }

    @Override
    public void override(Pidaimeicaiyang pidaimeicaiyang) {
        pidaimeicaiyangMapper.removeDetails(pidaimeicaiyang.getMybs());
        for (PidaimeicaiyangDetail detail : pidaimeicaiyang.getDtCydy()) {
            pidaimeicaiyangMapper.addDetail(detail);
        }

        pidaimeicaiyangMapper.override(pidaimeicaiyang);
    }

    @Override
    public List<Pidaimeicaiyang> queryForAutoUpload() {
        List<Pidaimeicaiyang> result = pidaimeicaiyangMapper.queryForAutoUpload();
        if (null != result) {
            for (Pidaimeicaiyang item : result) {
                item.setDtCydy(pidaimeicaiyangMapper.queryDetails(item.getMybs()));
            }
        }
        return result;
    }

    @Override
    public List<Pidaimeicaiyang> queryRecentRecords() {
        List<Pidaimeicaiyang> list = pidaimeicaiyangOracleMapper.queryRecentRecords();

        if (null == list || list.isEmpty()) {
            return Collections.emptyList();
        }

        for (Pidaimeicaiyang item : list) {
            if (null == item.getMybs() || item.getMybs().trim().isEmpty()) {
                continue;
            }
            List<PidaimeicaiyangDetail> details = pidaimeicaiyangOracleMapper.queryDetails(item.getMybs());
            item.setDtCydy(null == details ? Collections.emptyList() : details);
        }

        return list;
    }
}
