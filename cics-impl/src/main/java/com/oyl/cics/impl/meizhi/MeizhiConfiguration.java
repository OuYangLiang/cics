package com.oyl.cics.impl.meizhi;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MeizhiConfiguration {
    @Bean
    @Primary
    public MeizhiMapper meizhiMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<MeizhiMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(MeizhiMapper.class);
        return factory.getObject();
    }

}
