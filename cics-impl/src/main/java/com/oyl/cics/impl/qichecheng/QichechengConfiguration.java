package com.oyl.cics.impl.qichecheng;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    public QichechengOracleMapper qichechengOracleMapper(@Qualifier("sqlSessionFactoryForOracle") SqlSessionFactory sqlSessionFactoryForOracle) throws Exception {
        MapperFactoryBean<QichechengOracleMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactoryForOracle);
        factory.setMapperInterface(QichechengOracleMapper.class);
        return factory.getObject();
    }

}
