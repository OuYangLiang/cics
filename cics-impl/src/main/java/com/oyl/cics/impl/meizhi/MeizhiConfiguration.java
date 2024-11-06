package com.oyl.cics.impl.meizhi;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    public MeizhiOracleMapper meizhiOracleMapper(@Qualifier("sqlSessionFactoryForOracle") SqlSessionFactory sqlSessionFactoryForOracle) throws Exception {
        MapperFactoryBean<MeizhiOracleMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactoryForOracle);
        factory.setMapperInterface(MeizhiOracleMapper.class);
        return factory.getObject();
    }

}
