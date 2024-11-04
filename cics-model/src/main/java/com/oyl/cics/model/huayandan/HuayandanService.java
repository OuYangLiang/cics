package com.oyl.cics.model.huayandan;

import com.oyl.cics.model.common.utils.JsonUtil;
import com.oyl.cics.model.common.utils.http.Result;
import com.oyl.cics.model.shared.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class HuayandanService {

    private static final Logger log = LoggerFactory.getLogger(HuayandanService.class);

    @Resource
    private HuayandanDao huayandanDao;

    @Resource
    private Uploader uploader;

    public Result upload(List<Huayandan> huayandans, String operator) throws Exception {

        if (null != huayandans) {
            for (Huayandan item : huayandans) {
                item.setDefaultValues();
            }
        }

        Result result = uploader.uplaod("/api/dlhg/huayandan", JsonUtil.inst.toJson(huayandans));
        if (result.success()) {
            huayandanDao.uploadSucc(huayandans, operator);
        } else {
            log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
            huayandanDao.uploadFailed(huayandans, operator);
        }

        return result;
    }
}
