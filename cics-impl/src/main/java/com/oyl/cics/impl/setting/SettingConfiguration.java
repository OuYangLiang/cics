package com.oyl.cics.impl.setting;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SettingConfiguration {

    @Bean
    public SettingMapper settingMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<SettingMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(SettingMapper.class);
        return factory.getObject();
    }

}
