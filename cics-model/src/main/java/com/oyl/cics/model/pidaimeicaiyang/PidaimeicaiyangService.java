package com.oyl.cics.model.pidaimeicaiyang;

import com.oyl.cics.model.common.utils.JsonUtil;
import com.oyl.cics.model.common.utils.http.Result;
import com.oyl.cics.model.shared.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class PidaimeicaiyangService {

    private static final Logger log = LoggerFactory.getLogger(PidaimeicaiyangService.class);

    @Resource
    private PidaimeicaiyangDao pidaimeicaiyangDao;

    @Resource
    private Uploader uploader;

    public Result upload(List<Pidaimeicaiyang> pidaimeicaiyangs, String operator) throws Exception {

        if (null != pidaimeicaiyangs) {
            for (Pidaimeicaiyang item : pidaimeicaiyangs) {
                item.setDefaultValues();
            }
        }

        Result result = uploader.uplaod("/api/dlhg/pidaimeicaiyang", JsonUtil.inst.toJson(pidaimeicaiyangs));
        if (result.success()) {
            pidaimeicaiyangDao.uploadSucc(pidaimeicaiyangs, operator);
        } else {
            log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
            pidaimeicaiyangDao.uploadFailed(pidaimeicaiyangs, operator);
        }

        return result;
    }
}
