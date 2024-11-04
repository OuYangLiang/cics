package com.oyl.cics.model.meicaiyang;

import com.oyl.cics.model.common.utils.JsonUtil;
import com.oyl.cics.model.common.utils.http.Result;
import com.oyl.cics.model.shared.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class MeicaiyangService {

    private static final Logger log = LoggerFactory.getLogger(MeicaiyangService.class);

    @Resource
    private MeicaiyangDao meicaiyangDao;

    @Resource
    private Uploader uploader;

    public Result upload(List<Meicaiyang> meicaiyangs, String operator) throws Exception {

        if (null != meicaiyangs) {
            for (Meicaiyang item : meicaiyangs) {
                item.setDefaultValues();
            }
        }

        Result result = uploader.uplaod("/api/dlhg/meicaiyang", JsonUtil.inst.toJson(meicaiyangs));
        if (result.success()) {
            meicaiyangDao.uploadSucc(meicaiyangs, operator);
        } else {
            log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
            meicaiyangDao.uploadFailed(meicaiyangs, operator);
        }

        return result;
    }
}
