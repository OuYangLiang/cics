package com.oyl.cics.impl.common.util;

import com.oyl.cics.model.common.utils.AESUtil;
import com.oyl.cics.model.common.utils.http.HttpUtil;
import com.oyl.cics.model.common.utils.MD5Encryptor;
import com.oyl.cics.model.common.utils.RandomGenerator;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Tester {
    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IOException {
        String url = "http://10.151.64.244/mzkj/dlhg/pidaicheng";
        String json = "[{\"cheshu\":1,\"chexing\":\"123\",\"dtData\":[{\"zmxdocNo\":\"123\"}],\"duiweirq\":\"123\",\"duiweisj\":\"123\",\"jiliangdanwei\":\"123\",\"jlhqmc\":\"123\",\"jlhqyt\":\"1\",\"jltypetype\":\"1\",\"koudunzongliang\":1,\"mykuangdianbm\":\"123\",\"mykuangdianmc\":\"123\",\"shouchehao\":\"123\",\"sjtsdanwei\":\"123\",\"sjyxt\":\"123\",\"ssejdw\":\"123\",\"ssejdwid\":\"123\",\"sssjdw\":\"123\",\"sssjdwid\":\"123\",\"weichehao\":\"123\",\"xtscjlI\":\"123\",\"xtscjlT\":\"123\",\"yewurq\":\"123\",\"zccheci\":\"123\",\"zcmeizhong\":\"123\",\"zcmeizhongbm\":\"123\",\"zczhandian\":\"123\",\"zczhandianbm\":\"123\",\"zmxdocNo\":\"123\",\"zongjingzhong\":1,\"zongmaozhong\":1,\"zongpiaozhong\":1,\"zongpizhong\":1}]";

        String appId = "P24092600001";

        String appSecret = "67f64378ab857718";
        String dataSecret = "27f44dd996091d1c";

        String millis = Long.toString(System.currentTimeMillis());

        String nonce = RandomGenerator.inst.strs(6);

        Map<String, String> headers = new HashMap<>();
        headers.put("appId", appId);
        headers.put("millis", millis);
        headers.put("nonce", nonce);
        headers.put("sn", MD5Encryptor.inst.getMD5(appId + appSecret + millis + nonce).toLowerCase());
        headers.put("Content-Type", "application/json");

        String result = HttpUtil.inst.request(url, AESUtil.inst.encrypt(json, dataSecret), headers);

        System.out.println(result);
    }
}
