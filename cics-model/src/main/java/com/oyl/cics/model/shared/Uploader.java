package com.oyl.cics.model.shared;

import com.oyl.cics.model.common.cfg.PropertiesConfig;
import com.oyl.cics.model.common.utils.AESUtil;
import com.oyl.cics.model.common.utils.MD5Encryptor;
import com.oyl.cics.model.common.utils.RandomGenerator;
import com.oyl.cics.model.common.utils.http.HttpUtil;
import com.oyl.cics.model.common.utils.http.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class Uploader {

    private static final Logger log = LoggerFactory.getLogger(Uploader.class);

    @Resource
    private PropertiesConfig propertiesConfig;

    public Result uplaod(String url, String json, String group) throws Exception {

        log.info("准备上传数据，URL = {}, Data = {}", propertiesConfig.getUrl() + url, json);

        String millis = Long.toString(System.currentTimeMillis());
        String nonce = RandomGenerator.inst.strs(6);

        Map<String, String> headers = new HashMap<>();
        headers.put("appId", propertiesConfig.getAppId(group));
        headers.put("millis", millis);
        headers.put("nonce", nonce);
        headers.put("sn", MD5Encryptor.inst.getMD5(propertiesConfig.getAppId(group) + propertiesConfig.getAppSecret(group) + millis + nonce).toLowerCase());
        headers.put("Content-Type", "application/json");

        String encrypted = AESUtil.inst.encrypt(json, propertiesConfig.getDataSecret(group));
        String resultJson = HttpUtil.inst.request(propertiesConfig.getUrl() + url, encrypted, headers);
        return Result.fromJson(resultJson);
    }
}
