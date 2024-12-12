package com.oyl.cics.model.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    }

    public long numOfDays() {
        LocalDate date1 = LocalDate.of(2025, 3, 25);
        LocalDate date2 = LocalDate.now();
        return ChronoUnit.DAYS.between(date1, date2);
    }
}
