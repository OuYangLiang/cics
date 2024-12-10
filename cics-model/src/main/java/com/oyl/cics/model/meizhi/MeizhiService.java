package com.oyl.cics.model.meizhi;

import com.oyl.cics.model.common.utils.JsonUtil;
import com.oyl.cics.model.common.utils.http.Result;
import com.oyl.cics.model.shared.Grouper;
import com.oyl.cics.model.shared.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MeizhiService {

    private static final Logger log = LoggerFactory.getLogger(MeizhiService.class);

    @Resource
    private MeizhiDao meizhiDao;

    @Resource
    private Uploader uploader;

    public void autoUpload() throws Exception {
        List<Meizhi> meizhis = meizhiDao.queryForAutoUpload();
        if (null != meizhis && !meizhis.isEmpty()) {
            log.info("拉取{}条数据，准备自动上传", meizhis.size());
            this.upload(meizhis, "System");
        }
    }

    public boolean upload(List<Meizhi> meizhis, String operator) throws Exception {

        if (null == meizhis) {
            throw new IllegalArgumentException();
        }

        for (Meizhi item : meizhis) {
            item.setDefaultValues();
        }

        Map<String, List<Meizhi>> map = meizhis.stream().collect(Collectors.groupingBy(i -> Grouper.inst.group(i.getSssjdwid())));

        boolean success = true;
        for (Map.Entry<String, List<Meizhi>> entry : map.entrySet()) {
            Result result = uploader.uplaod("/api/dlhg/meizhi", JsonUtil.inst.toJson(entry.getValue()), entry.getKey());
            if (result.success()) {
                log.info("上报成功，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                meizhiDao.uploadSucc(entry.getValue(), operator);
            } else {
                success = false;
                log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                meizhiDao.uploadFailed(entry.getValue(), operator);
            }
        }

        return success;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Meizhi meizhi) {
        if (null == meizhi.getMybs() || meizhi.getMybs().isEmpty()) {
            throw new IllegalStateException();
        }
        meizhiDao.override(meizhi);
    }
}
