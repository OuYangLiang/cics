package com.oyl.cics.impl.kjhuayandan;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class KjhuayandanConfiguration {

    @Bean
    @Primary
    public KjhuayandanMapper kjhuayandanMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<KjhuayandanMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(KjhuayandanMapper.class);
        return factory.getObject();
    }
}
