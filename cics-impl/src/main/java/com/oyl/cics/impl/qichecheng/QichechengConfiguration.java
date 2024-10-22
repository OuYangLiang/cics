package com.oyl.cics.impl.qichecheng;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class QichechengConfiguration {

    @Bean
    @Primary
    public QichechengMapper qichechengMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<QichechengMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(QichechengMapper.class);
        return factory.getObject();
    }

}
