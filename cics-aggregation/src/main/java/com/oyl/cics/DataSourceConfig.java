package com.oyl.cics;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DataSourceConfig {

    private static final int DEFAULT_POOL_SIZE = 10;

    @Bean
    @Primary
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource rlt = new ComboPooledDataSource();
//        rlt.setDriverClass("com.mysql.jdbc.Driver");
        rlt.setDriverClass("com.mysql.cj.jdbc.Driver");
        rlt.setUser("root");
        rlt.setPassword("pwd12345");
        rlt.setJdbcUrl("jdbc:mysql://localhost:3306/cics");
        rlt.setInitialPoolSize(DEFAULT_POOL_SIZE);
        rlt.setMaxPoolSize(DEFAULT_POOL_SIZE);
        rlt.setMinPoolSize(DEFAULT_POOL_SIZE);
        rlt.setTestConnectionOnCheckin(true);
        rlt.setPreferredTestQuery("select 1");

        return rlt;
    }

    @Bean
    public DataSource dataSourceForOracle() throws PropertyVetoException {
        ComboPooledDataSource rlt = new ComboPooledDataSource();
        rlt.setDriverClass("oracle.jdbc.driver.OracleDriver");
        rlt.setUser("FMIS9999");
        rlt.setPassword("FMIS9999");
//        rlt.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        rlt.setJdbcUrl("jdbc:oracle:thin:@192.168.10.4:1521:XE0728");
        rlt.setInitialPoolSize(DEFAULT_POOL_SIZE);
        rlt.setMaxPoolSize(DEFAULT_POOL_SIZE);
        rlt.setMinPoolSize(DEFAULT_POOL_SIZE);
        rlt.setTestConnectionOnCheckin(true);
        rlt.setPreferredTestQuery("select 1");

        return rlt;
    }

}
