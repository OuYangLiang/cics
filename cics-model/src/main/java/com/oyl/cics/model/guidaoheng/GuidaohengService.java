package com.oyl.cics.model.guidaoheng;

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
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class GuidaohengService {

    private static final Logger log = LoggerFactory.getLogger(GuidaohengService.class);

    @Resource
    private GuidaohengDao guidaohengDao;

    @Resource
    private Uploader uploader;

    public boolean upload(List<Guidaoheng> guidaohengs, String operator) throws Exception {

        if (null == guidaohengs) {
            throw new IllegalArgumentException();
        }

        for (Guidaoheng item : guidaohengs) {
            item.setDefaultValues();
        }

        Map<String, List<Guidaoheng>> map = guidaohengs.stream().collect(Collectors.groupingBy(i -> Grouper.inst.group(i.getSssjdwid())));

        boolean success = true;
        for (Map.Entry<String, List<Guidaoheng>> entry : map.entrySet()) {
            Result result = uploader.uplaod("/api/dlhg/guidaoheng", JsonUtil.inst.toJson(entry.getValue()), entry.getKey());
            if (result.success()) {
                log.info("上报成功，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                guidaohengDao.uploadSucc(entry.getValue(), operator);
            } else {
                success = false;
                log.warn("上报失败，code={}, msg={}, data={}", result.getCode(), result.getMsg(), result.getData());
                guidaohengDao.uploadFailed(entry.getValue(), operator);
            }
        }

        return success;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void override(Guidaoheng guidaoheng) {
        if (null == guidaoheng.getZmxdocNo() || guidaoheng.getZmxdocNo().isEmpty()) {
            throw new IllegalStateException();
        }
        guidaohengDao.override(guidaoheng);
    }

}
