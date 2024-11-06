package com.oyl.cics.model.common.cfg;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config")
@Getter
@Setter
public class PropertiesConfig {
    private String appId;
    private String appSecret;
    private String dataSecret;
    private String url;
    private String mysqlDriverClass;
    private String mysqlUser;
    private String mysqlPwd;
}
