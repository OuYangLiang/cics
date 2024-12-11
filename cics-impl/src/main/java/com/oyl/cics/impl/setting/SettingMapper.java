package com.oyl.cics.impl.setting;

public interface SettingMapper {
    String query(String group, String key);

    void set(String group, String key, String value);
}
