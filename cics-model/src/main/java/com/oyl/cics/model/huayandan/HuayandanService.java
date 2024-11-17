package com.oyl.cics.model.huayandan;

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
public class HuayandanService {

    private static final Logger log = LoggerFactory.getLogger(HuayandanService.class);

    @Resource
    private HuayandanDao huayandanDao;

    @Resource
    private Uploader uploader;

    public boolean upload(List<Huayandan> huayandans, String operator) throws Exception {

        if (null != huayandans) {
            for (Huayandan item : huayandans) {
                item.setDefaultValues();
            }
        }

        Map<String, List<Huayandan>> map = huayandans.stream().collect(Collectors.groupingBy(i -> Grouper.inst.group(i.getSssjdwid())));

        boolean success = true;
        for (Map.Entry<String, List<Huayandan>> entry : map.entrySet()) {
            Result result = uploader.uplaod("/api/dlhg/huayandan", JsonUtil.inst.toJson(entry.getValue()), entry.getKey());
            if (result.success()) {
                huayandanDao.uploadSucc(entry.getValue(), operator);
            } else {
                success = false;
                log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                huayandanDao.uploadFailed(entry.getValue(), operator);
            }
        }

        return success;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Huayandan huayandan) {
        if (null == huayandan.getMybs() || huayandan.getMybs().isEmpty()) {
            throw new IllegalStateException();
        }
        huayandanDao.override(huayandan);
    }
}
