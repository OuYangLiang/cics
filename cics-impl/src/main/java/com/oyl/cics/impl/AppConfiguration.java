package com.oyl.cics.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:sqlMap/mysql/*.xml"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryForOracle(@Qualifier("dataSourceForOracle") DataSource dataSourceForOracle) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSourceForOracle);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:sqlMap/oracle/*.xml"));
        return bean.getObject();
    }

}
