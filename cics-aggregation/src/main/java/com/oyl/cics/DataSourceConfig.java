package com.oyl.cics;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.oyl.cics.model.common.cfg.PropertiesConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
public class DataSourceConfig {

    private static final int DEFAULT_POOL_SIZE = 10;

    @Resource
    private PropertiesConfig propertiesConfig;

    @Bean
    @Primary
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource rlt = new ComboPooledDataSource();
        rlt.setDriverClass(propertiesConfig.getMysqlDriverClass());
        rlt.setUser(propertiesConfig.getMysqlUser());
        rlt.setPassword(propertiesConfig.getMysqlPwd());
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
//        rlt.setJdbcUrl("jdbc:oracle:thin:@192.168.10.4:1521:XE0728");
        rlt.setJdbcUrl("jdbc:oracle:thin:@" + propertiesConfig.getOracleUrl() + ":1521:XE0728");
        rlt.setInitialPoolSize(DEFAULT_POOL_SIZE);
        rlt.setMaxPoolSize(DEFAULT_POOL_SIZE);
        rlt.setMinPoolSize(DEFAULT_POOL_SIZE);
        rlt.setTestConnectionOnCheckin(true);
        rlt.setPreferredTestQuery("select 1");

        return rlt;
    }

}
