package com.oyl.cics.model.guidaoheng;

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
public class GuidaohengService {

    private static final Logger log = LoggerFactory.getLogger(GuidaohengService.class);

    @Resource
    private GuidaohengDao guidaohengDao;

    @Resource
    private Uploader uploader;

    public Result upload(List<Guidaoheng> guidaohengs, String operator) throws Exception {

        if (null != guidaohengs) {
            for (Guidaoheng item : guidaohengs) {
                item.setDefaultValues();
            }
        }

        Result result = uploader.uplaod("/api/dlhg/guidaoheng", JsonUtil.inst.toJson(guidaohengs));
        if (result.success()) {
            guidaohengDao.uploadSucc(guidaohengs, operator);
        } else {
            log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
            guidaohengDao.uploadFailed(guidaohengs, operator);
        }

        return result;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Guidaoheng guidaoheng) {
        if (null == guidaoheng.getZmxdocNo() || guidaoheng.getZmxdocNo().isEmpty()) {
            throw new IllegalStateException();
        }
        guidaohengDao.override(guidaoheng);
    }

}
