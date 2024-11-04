package com.oyl.cics.model.shared;

import com.oyl.cics.model.common.cfg.PropertiesConfig;
import com.oyl.cics.model.common.utils.AESUtil;
import com.oyl.cics.model.common.utils.MD5Encryptor;
import com.oyl.cics.model.common.utils.RandomGenerator;
import com.oyl.cics.model.common.utils.http.HttpUtil;
import com.oyl.cics.model.common.utils.http.Result;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class Uploader {

    @Resource
    private PropertiesConfig propertiesConfig;

    public Result uplaod(String url, String json) throws Exception {

        String millis = Long.toString(System.currentTimeMillis());
        String nonce = RandomGenerator.inst.strs(6);

        Map<String, String> headers = new HashMap<>();
        headers.put("appId", propertiesConfig.getAppId());
        headers.put("millis", millis);
        headers.put("nonce", nonce);
        headers.put("sn", MD5Encryptor.inst.getMD5(propertiesConfig.getAppId() + propertiesConfig.getAppSecret() + millis + nonce).toLowerCase());
        headers.put("Content-Type", "application/json");

        String encrypted = AESUtil.inst.encrypt(json, propertiesConfig.getDataSecret());
        String resultJson = HttpUtil.inst.request(propertiesConfig.getUrl() + url, encrypted, headers);
        return Result.fromJson(resultJson);
    }
}
