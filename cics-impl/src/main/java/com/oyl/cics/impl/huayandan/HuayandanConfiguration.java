package com.oyl.cics.impl.huayandan;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HuayandanConfiguration {

    @Bean
    @Primary
    public HuayandanMapper huayandanMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<HuayandanMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(HuayandanMapper.class);
        return factory.getObject();
    }

    @Bean
    public HuayandanOracleMapper huayandanOracleMapper(@Qualifier("sqlSessionFactoryForOracle") SqlSessionFactory sqlSessionFactoryForOracle) throws Exception {
        MapperFactoryBean<HuayandanOracleMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactoryForOracle);
        factory.setMapperInterface(HuayandanOracleMapper.class);
        return factory.getObject();
    }
}
