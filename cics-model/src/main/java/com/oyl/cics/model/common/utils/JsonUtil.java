package com.oyl.cics.model.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public enum JsonUtil {
    inst;

    private final Gson gson = new GsonBuilder().serializeNulls().create();

    public String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public <T> T fromJson(String json, Class<T> t) {
        return gson.fromJson(json, t);
    }

    /*public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUsername("OYL");
        user.setPassword("123");

        String json = JsonUtil.inst.toJson(user);
        System.out.println(json);
        User user1 = JsonUtil.inst.fromJson(json, User.class);
        System.out.println(JsonUtil.inst.toJson(user1));
    }*/
}
