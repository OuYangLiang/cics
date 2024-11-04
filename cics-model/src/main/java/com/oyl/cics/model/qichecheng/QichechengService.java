package com.oyl.cics.model.qichecheng;

import com.oyl.cics.model.common.utils.JsonUtil;
import com.oyl.cics.model.common.utils.http.Result;
import com.oyl.cics.model.shared.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class QichechengService {

    private static final Logger log = LoggerFactory.getLogger(QichechengService.class);

    @Resource
    private QichechengDao qichechengDao;

    @Resource
    private Uploader uploader;

    public Result upload(List<Qichecheng> qichechengs, String operator) throws Exception {

        if (null != qichechengs) {
            for (Qichecheng item : qichechengs) {
                item.setDefaultValues();
            }
        }

        Result result = uploader.uplaod("/api/dlhg/qichecheng", JsonUtil.inst.toJson(qichechengs));
        if (result.success()) {
            qichechengDao.uploadSucc(qichechengs, operator);
        } else {
            log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
            qichechengDao.uploadFailed(qichechengs, operator);
        }

        return result;
    }
}
