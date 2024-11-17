package com.oyl.cics.model.meicaiyang;

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
public class MeicaiyangService {

    private static final Logger log = LoggerFactory.getLogger(MeicaiyangService.class);

    @Resource
    private MeicaiyangDao meicaiyangDao;

    @Resource
    private Uploader uploader;

    public boolean upload(List<Meicaiyang> meicaiyangs, String operator) throws Exception {

        if (null == meicaiyangs) {
            throw new IllegalArgumentException();
        }

        for (Meicaiyang item : meicaiyangs) {
            item.setDefaultValues();
        }

        Map<String, List<Meicaiyang>> map = meicaiyangs.stream().collect(Collectors.groupingBy(i -> Grouper.inst.group(i.getSssjdwid())));

        boolean success = true;
        for (Map.Entry<String, List<Meicaiyang>> entry : map.entrySet()) {
            Result result = uploader.uplaod("/api/dlhg/meicaiyang", JsonUtil.inst.toJson(entry.getValue()), entry.getKey());
            if (result.success()) {
                meicaiyangDao.uploadSucc(entry.getValue(), operator);
            } else {
                success = false;
                log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                meicaiyangDao.uploadFailed(entry.getValue(), operator);
            }
        }

        return success;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Meicaiyang meicaiyang) {
        if (null == meicaiyang.getMybs() || meicaiyang.getMybs().isEmpty()) {
            throw new IllegalStateException();
        }
        meicaiyangDao.override(meicaiyang);
    }
}
