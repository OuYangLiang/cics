package com.oyl.cics.model.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public enum AESUtil {
    inst;

    private final String Algorithm = "AES";
    private final String AlgorithmProvider = "AES/ECB/PKCS5Padding";

    public String encrypt(String sSrc, String sKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if (null == sKey || sKey.length() != 16) {
            throw new IllegalArgumentException("Invalid key");
        }

        if (null == sSrc) {
            throw new IllegalArgumentException("Invalid sSrc");
        }

        byte[] raw = sKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, Algorithm);
        Cipher cipher = Cipher.getInstance(AlgorithmProvider);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8));
        return new BASE64Encoder().encode(encrypted).replaceAll("\r\n","").replaceAll("\r","").replaceAll("\n","");//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    public String decrypt(String sSrc, String sKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        if (null == sKey || sKey.length() != 16) {
            throw new IllegalArgumentException("Invalid key");
        }

        if (null == sSrc) {
            throw new IllegalArgumentException("Invalid sSrc");
        }

        byte[] raw = sKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, Algorithm);
        Cipher cipher = Cipher.getInstance(AlgorithmProvider);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
        byte[] original = cipher.doFinal(encrypted1);
        return new String(original, StandardCharsets.UTF_8);
    }

    /*public static void main(String[] args) throws Exception {
        //客户端loginToken
        String  json = "[{\"cheshu\":1,\"chexing\":\"123\",\"dtData\":[{\"zmxdocNo\":\"123\"}],\"duiweirq\":\"123\",\"duiweisj\":\"123\",\"jiliangdanwei\":\"123\",\"jlhqmc\":\"123\",\"jlhqyt\":\"1\",\"jltypetype\":\"1\",\"koudunzongliang\":1,\"mykuangdianbm\":\"123\",\"mykuangdianmc\":\"123\",\"shouchehao\":\"123\",\"sjtsdanwei\":\"123\",\"sjyxt\":\"123\",\"ssejdw\":\"123\",\"ssejdwid\":\"123\",\"sssjdw\":\"123\",\"sssjdwid\":\"123\",\"weichehao\":\"123\",\"xtscjlI\":\"123\",\"xtscjlT\":\"123\",\"yewurq\":\"123\",\"zccheci\":\"123\",\"zcmeizhong\":\"123\",\"zcmeizhongbm\":\"123\",\"zczhandian\":\"123\",\"zczhandianbm\":\"123\",\"zmxdocNo\":\"123\",\"zongjingzhong\":1,\"zongmaozhong\":1,\"zongpiaozhong\":1,\"zongpizhong\":1}]";

        String key = "27f44dd996091d1c";

        String encodeToken = inst.encrypt(json, key);
        String decodeToken = inst.decrypt(encodeToken, key);
        System.out.printf("encodeToken:%s%n", encodeToken);
        System.out.printf("decodeToken:%s%n", decodeToken);
        System.out.printf("equals: %s", json.equals(decodeToken));
    }*/
}

