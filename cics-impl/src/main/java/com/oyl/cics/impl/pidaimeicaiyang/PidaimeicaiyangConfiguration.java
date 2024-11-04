package com.oyl.cics.impl.pidaimeicaiyang;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PidaimeicaiyangConfiguration {
    @Bean
    @Primary
    public PidaimeicaiyangMapper pidaimeicaiyangMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<PidaimeicaiyangMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(PidaimeicaiyangMapper.class);
        return factory.getObject();
    }
}