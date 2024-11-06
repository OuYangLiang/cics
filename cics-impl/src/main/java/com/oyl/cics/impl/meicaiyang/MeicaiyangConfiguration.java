package com.oyl.cics.impl.meicaiyang;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MeicaiyangConfiguration {

    @Bean
    @Primary
    public MeicaiyangMapper meicaiyangMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<MeicaiyangMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(MeicaiyangMapper.class);
        return factory.getObject();
    }

    @Bean
    public MeicaiyangOracleMapper meicaiyangOracleMapper(@Qualifier("sqlSessionFactoryForOracle") SqlSessionFactory sqlSessionFactoryForOracle) throws Exception {
        MapperFactoryBean<MeicaiyangOracleMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactoryForOracle);
        factory.setMapperInterface(MeicaiyangOracleMapper.class);
        return factory.getObject();
    }
}
