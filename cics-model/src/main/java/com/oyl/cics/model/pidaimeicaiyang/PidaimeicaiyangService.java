package com.oyl.cics.model.pidaimeicaiyang;

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
public class PidaimeicaiyangService {

    private static final Logger log = LoggerFactory.getLogger(PidaimeicaiyangService.class);

    @Resource
    private PidaimeicaiyangDao pidaimeicaiyangDao;

    @Resource
    private Uploader uploader;

    public void autoUpload() throws Exception {
        List<Pidaimeicaiyang> pidaimeicaiyangs = pidaimeicaiyangDao.queryForAutoUpload();
        if (null != pidaimeicaiyangs && !pidaimeicaiyangs.isEmpty()) {
            log.info("拉取{}条数据，准备自动上传", pidaimeicaiyangs.size());
            this.upload(pidaimeicaiyangs, "System");
        }
    }

    public boolean upload(List<Pidaimeicaiyang> pidaimeicaiyangs, String operator) throws Exception {

        if (null == pidaimeicaiyangs) {
            throw new IllegalArgumentException();
        }

        for (Pidaimeicaiyang item : pidaimeicaiyangs) {
            item.setDefaultValues();
        }

        Map<String, List<Pidaimeicaiyang>> map = pidaimeicaiyangs.stream().collect(Collectors.groupingBy(i -> Grouper.inst.group(i.getSssjdwid())));

        boolean success = true;
        for (Map.Entry<String, List<Pidaimeicaiyang>> entry : map.entrySet()) {
            Result result = uploader.uplaod("/api/dlhg/pidaimeicaiyang", JsonUtil.inst.toJson(entry.getValue()), entry.getKey());
            if (result.success()) {
                log.info("上报成功，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                pidaimeicaiyangDao.uploadSucc(entry.getValue(), operator);
            } else {
                success = false;
                log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                pidaimeicaiyangDao.uploadFailed(entry.getValue(), operator);
            }
        }

        return success;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Pidaimeicaiyang pidaimeicaiyang) {
        if (null == pidaimeicaiyang.getMybs() || pidaimeicaiyang.getMybs().isEmpty()) {
            throw new IllegalStateException();
        }
        pidaimeicaiyangDao.override(pidaimeicaiyang);
    }
}
