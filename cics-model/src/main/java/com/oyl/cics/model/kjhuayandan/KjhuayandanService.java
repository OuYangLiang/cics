package com.oyl.cics.model.kjhuayandan;

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
public class KjhuayandanService {

    private static final Logger log = LoggerFactory.getLogger(KjhuayandanService.class);

    @Resource
    private KjhuayandanDao kjhuayandanDao;

    @Resource
    private Uploader uploader;

    public boolean upload(List<Kjhuayandan> huayandans, String operator) throws Exception {

        if (null != huayandans) {
            for (Kjhuayandan item : huayandans) {
                item.setDefaultValues();
            }
        }

        Map<String, List<Kjhuayandan>> map = null;//huayandans.stream().collect(Collectors.groupingBy(i -> Grouper.inst.group(i.getSssjdwid())));

        boolean success = true;
        for (Map.Entry<String, List<Kjhuayandan>> entry : map.entrySet()) {
            Result result = uploader.uplaod("/api/zcwg/kjhuayandan", JsonUtil.inst.toJson(entry.getValue()), entry.getKey());
            if (result.success()) {
                log.info("上报成功，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                kjhuayandanDao.uploadSucc(entry.getValue(), operator);
            } else {
                success = false;
                log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                kjhuayandanDao.uploadFailed(entry.getValue(), operator);
            }
        }

        return success;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Kjhuayandan kjhuayandan) {
        if (null == kjhuayandan.getMybs() || kjhuayandan.getMybs().isEmpty()) {
            throw new IllegalStateException();
        }
        kjhuayandanDao.override(kjhuayandan);
    }
}
