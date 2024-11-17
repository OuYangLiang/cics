package com.oyl.cics.model.shared;

public enum Grouper {
    inst;

    public String group(String sssjdwid) {

        if ("MD0107".equalsIgnoreCase(sssjdwid) || "2667".equalsIgnoreCase(sssjdwid)) {
            return "G1";
        } else if (("MD0108".equalsIgnoreCase(sssjdwid) || "2668".equalsIgnoreCase(sssjdwid))) {
            return "G2";
        }

        throw new IllegalStateException("未知分组");
    }
}
