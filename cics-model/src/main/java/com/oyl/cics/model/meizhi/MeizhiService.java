package com.oyl.cics.model.meizhi;

import com.oyl.cics.model.common.utils.JsonUtil;
import com.oyl.cics.model.common.utils.http.Result;
import com.oyl.cics.model.shared.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MeizhiService {

    private static final Logger log = LoggerFactory.getLogger(MeizhiService.class);

    @Resource
    private MeizhiDao meizhiDao;

    @Resource
    private Uploader uploader;

    public Result upload(List<Meizhi> meizhis, String operator) throws Exception {

        if (null != meizhis) {
            for (Meizhi item : meizhis) {
                item.setDefaultValues();
            }
        }

        Result result = uploader.uplaod("/api/dlhg/meizhi", JsonUtil.inst.toJson(meizhis));
        if (result.success()) {
            meizhiDao.uploadSucc(meizhis, operator);
        } else {
            log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
            meizhiDao.uploadFailed(meizhis, operator);
        }

        return result;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Meizhi meizhi) {
        if (null == meizhi.getMybs() || meizhi.getMybs().isEmpty()) {
            throw new IllegalStateException();
        }
        meizhiDao.override(meizhi);
    }
}
