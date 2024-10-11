package com.oyl.cics.impl.guidaoheng;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GuidaohengConfiguration {

    @Bean
    public GuidaohengMapper guidaohengMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<GuidaohengMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(GuidaohengMapper.class);
        return factory.getObject();
    }

}
