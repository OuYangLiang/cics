package com.oyl.cics.impl.qichecheng;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QichechengConfiguration {

    @Bean
    public QichechengMapper qichechengMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<QichechengMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(QichechengMapper.class);
        return factory.getObject();
    }

}
