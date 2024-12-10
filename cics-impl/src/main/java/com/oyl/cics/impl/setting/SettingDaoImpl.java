package com.oyl.cics.impl.setting;

import com.oyl.cics.model.setting.SettingDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SettingDaoImpl implements SettingDao {
    @Resource
    private SettingMapper settingMapper;

    @Override
    public String query(String group, String key) {
        return settingMapper.query(group, key);
    }
}
