package com.oyl.cics.impl.user;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserMapper userMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<UserMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(UserMapper.class);
        return factory.getObject();
    }

}