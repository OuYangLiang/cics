package com.oyl.cics.impl.common.util;

import com.oyl.cics.impl.common.cfg.PropertiesConfig;
import com.oyl.cics.model.guidaoheng.Guidaoheng;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Submitter {

    @Resource
    private PropertiesConfig propertiesConfig;

    public String submit(Guidaoheng guidaoheng) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IOException {
        String url = propertiesConfig.getUrl() + "/dlhg/guidaoheng";
        String millis = Long.toString(System.currentTimeMillis());
        String nonce = RandomGenerator.inst.strs(6);

        Map<String, String> headers = new HashMap<>();
        headers.put("appId", propertiesConfig.getAppId());
        headers.put("millis", millis);
        headers.put("nonce", nonce);
        headers.put("sn", MD5Encryptor.inst.getMD5(propertiesConfig.getAppId() + propertiesConfig.getAppSecret() + millis + nonce).toLowerCase());
        headers.put("Content-Type", "application/json");

        String json = JsonUtil.inst.toJson(guidaoheng);
        String encrypted = AESUtil.inst.encrypt(json, propertiesConfig.getDataSecret());

        String result = HttpUtil.inst.request(url, encrypted, headers);

        System.out.println(result);
        return result;
    }
}
