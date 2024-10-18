package com.oyl.cics.model.common.utils.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private static final Gson gson = new GsonBuilder().create();

    private Integer code;
    private String msg;
    private String data;

    public boolean success() {
        return code != null && 0 == code;
    }

    public static Result fromJson(String json) {
        return gson.fromJson(json, Result.class);
    }
}
