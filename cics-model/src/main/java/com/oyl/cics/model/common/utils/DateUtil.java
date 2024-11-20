package com.oyl.cics.model.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateUtil {
    inst;

    public String date() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(now);
    }

    public String time() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        return sdf.format(now);
    }

    public static void main(String[] args) {

        System.out.println(DateUtil.inst.date());
        System.out.println(DateUtil.inst.time());
    }
}
