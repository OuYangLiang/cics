package com.oyl.cics.impl.guidaoheng;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GuidaohengConfiguration {

    @Bean
    @Primary
    public GuidaohengMapper guidaohengMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<GuidaohengMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(GuidaohengMapper.class);
        return factory.getObject();
    }

    @Bean
    public GuidaohengOracleMapper guidaohengOracleMapper(@Qualifier("sqlSessionFactoryForOracle") SqlSessionFactory sqlSessionFactoryForOracle) throws Exception {
        MapperFactoryBean<GuidaohengOracleMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactoryForOracle);
        factory.setMapperInterface(GuidaohengOracleMapper.class);
        return factory.getObject();
    }

}
