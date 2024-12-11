package com.oyl.cics.model.setting;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SettingService {
    @Resource
    private SettingDao settingDao;

    public boolean autoUpload() {
        String val = settingDao.query("Common", "autoUpload");

        return Boolean.parseBoolean(val);
    }

    public void setAutoUpload(boolean val) {
        settingDao.set("Common", "autoUpload", Boolean.toString(val));
    }
}
