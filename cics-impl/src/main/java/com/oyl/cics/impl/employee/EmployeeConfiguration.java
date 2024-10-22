package com.oyl.cics.impl.employee;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EmployeeConfiguration {
    @Bean
    @Primary
    public EmployeeMapper employeeMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
        MapperFactoryBean<EmployeeMapper> factory = new MapperFactoryBean<>();
        factory.setSqlSessionFactory(sqlSessionFactory);
        factory.setMapperInterface(EmployeeMapper.class);
        return factory.getObject();
    }
}
