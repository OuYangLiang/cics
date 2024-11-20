package com.oyl.cics.model.qichecheng;

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
public class QichechengService {

    private static final Logger log = LoggerFactory.getLogger(QichechengService.class);

    @Resource
    private QichechengDao qichechengDao;

    @Resource
    private Uploader uploader;

    public boolean upload(List<Qichecheng> qichechengs, String operator) throws Exception {

        if (null == qichechengs) {
            throw new IllegalArgumentException();
        }

        for (Qichecheng item : qichechengs) {
            item.setDefaultValues();
        }

        Map<String, List<Qichecheng>> map = qichechengs.stream().collect(Collectors.groupingBy(i -> Grouper.inst.group(i.getSssjdwid())));

        boolean success = true;
        for (Map.Entry<String, List<Qichecheng>> entry : map.entrySet()) {
            Result result = uploader.uplaod("/api/dlhg/qichecheng", JsonUtil.inst.toJson(entry.getValue()), entry.getKey());
            if (result.success()) {
                log.info("上报成功，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                qichechengDao.uploadSucc(entry.getValue(), operator);
            } else {
                success = false;
                log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                qichechengDao.uploadFailed(entry.getValue(), operator);
            }
        }

        return success;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Qichecheng qichecheng) {
        if (null == qichecheng.getZmxdocNo() || qichecheng.getZmxdocNo().isEmpty()) {
            throw new IllegalStateException();
        }
        qichechengDao.override(qichecheng);
    }
}
