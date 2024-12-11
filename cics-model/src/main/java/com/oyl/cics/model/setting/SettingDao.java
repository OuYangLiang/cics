package com.oyl.cics.model.setting;

public interface SettingDao {
    String query(String group, String key);

    void set(String group, String key, String value);
}
