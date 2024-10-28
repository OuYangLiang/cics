package com.oyl.cics.model.guidaoheng;

import com.oyl.cics.model.common.cfg.PropertiesConfig;
import com.oyl.cics.model.common.utils.AESUtil;
import com.oyl.cics.model.common.utils.JsonUtil;
import com.oyl.cics.model.common.utils.MD5Encryptor;
import com.oyl.cics.model.common.utils.RandomGenerator;
import com.oyl.cics.model.common.utils.http.HttpUtil;
import com.oyl.cics.model.common.utils.http.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GuidaohengService {

    private static final Logger log = LoggerFactory.getLogger(GuidaohengService.class);

    @Resource
    private PropertiesConfig propertiesConfig;

    @Resource
    private GuidaohengDao guidaohengDao;

    public Result upload(List<Guidaoheng> guidaohengs, String operator) throws Exception {
        String url = propertiesConfig.getUrl() + "/api/dlhg/guidaoheng";
        String millis = Long.toString(System.currentTimeMillis());
        String nonce = RandomGenerator.inst.strs(6);

        Map<String, String> headers = new HashMap<>();
        headers.put("appId", propertiesConfig.getAppId());
        headers.put("millis", millis);
        headers.put("nonce", nonce);
        headers.put("sn", MD5Encryptor.inst.getMD5(propertiesConfig.getAppId() + propertiesConfig.getAppSecret() + millis + nonce).toLowerCase());
        headers.put("Content-Type", "application/json");

        if (null != guidaohengs) {
            for (Guidaoheng item : guidaohengs) {
                item.setDefaultValues();
            }
        }

        String json = JsonUtil.inst.toJson(guidaohengs);
        String encrypted = AESUtil.inst.encrypt(json, propertiesConfig.getDataSecret());

        String resultJson = HttpUtil.inst.request(url, encrypted, headers);
        Result result = Result.fromJson(resultJson);

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
