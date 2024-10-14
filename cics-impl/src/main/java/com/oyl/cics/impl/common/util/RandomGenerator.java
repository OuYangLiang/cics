package com.oyl.cics.impl.common.util;

import java.util.Random;

public enum RandomGenerator {
    inst;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public String strs(int length) {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(index));
        }
        return stringBuilder.toString();
    }

    /*public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            String randomString = RandomGenerator.inst.strs(6);
            System.out.println("生成的6位随机字符串是: " + randomString);
        }
    }*/

}
