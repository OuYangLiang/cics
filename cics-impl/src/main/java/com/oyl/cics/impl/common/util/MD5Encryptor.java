package com.oyl.cics.impl.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public enum MD5Encryptor {
    inst;

    public String getMD5(String input) {
        try {
            // 获取MD5算法的MessageDigest实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 更新摘要以包含指定的字节数组（输入字符串的字节表示）
            md.update(input.getBytes());

            // 计算哈希值，结果为字节数组
            byte[] digest = md.digest();

            // 将字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /*public static void main(String[] args) {
        String input = "Hello, World!";
        String md5Hash = MD5Encryptor.inst.getMD5(input);
        System.out.println("MD5 hash of '" + input + "' is: " + md5Hash);
    }*/
}
