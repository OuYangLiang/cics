package com.oyl.cics.model.kjhuayandan;

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
public class KjhuayandanService {

    private static final Logger log = LoggerFactory.getLogger(KjhuayandanService.class);

    @Resource
    private KjhuayandanDao kjhuayandanDao;

    @Resource
    private Uploader uploader;

    public Result upload(List<Kjhuayandan> kjhuayandans, String operator) throws Exception {

        if (null != kjhuayandans) {
            for (Kjhuayandan item : kjhuayandans) {
                item.setDefaultValues();
            }
        }

        Result result = uploader.uplaod("/api/zcwg/kjhuayandan", JsonUtil.inst.toJson(kjhuayandans), "G1");
        if (result.success()) {
            kjhuayandanDao.uploadSucc(kjhuayandans, operator);
        } else {
            log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
            kjhuayandanDao.uploadFailed(kjhuayandans, operator);
        }

        return result;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Kjhuayandan kjhuayandan) {
        if (null == kjhuayandan.getMybs() || kjhuayandan.getMybs().isEmpty()) {
            throw new IllegalStateException();
        }
        kjhuayandanDao.override(kjhuayandan);
    }
}
