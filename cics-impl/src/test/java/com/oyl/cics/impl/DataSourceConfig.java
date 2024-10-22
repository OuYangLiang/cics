package com.oyl.cics.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource rlt = new ComboPooledDataSource();
        rlt.setDriverClass("org.h2.Driver");
        rlt.setJdbcUrl("jdbc:h2:mem:test;MODE=MySQL");
        return rlt;
    }

    @Bean
    public DataSource dataSourceForOracle() throws PropertyVetoException {
        ComboPooledDataSource rlt = new ComboPooledDataSource();
        rlt.setDriverClass("org.h2.Driver");
        rlt.setJdbcUrl("jdbc:h2:mem:test;MODE=MySQL");
        return rlt;
    }

}
