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
    private String appIdG1;
    private String appSecretG1;
    private String dataSecretG1;
    private String appIdG2;
    private String appSecretG2;
    private String dataSecretG2;
    private String url;
    private String mysqlDriverClass;
    private String mysqlUser;
    private String mysqlPwd;
    private String oracleUrl;

    public String getAppId(String group) {
        if ("G1".equalsIgnoreCase(group)) {
            return this.getAppIdG1();
        } else {
            return this.getAppIdG2();
        }
    }

    public String getAppSecret(String group) {
        if ("G1".equalsIgnoreCase(group)) {
            return this.getAppSecretG1();
        } else {
            return this.getAppSecretG1();
        }
    }

    public String getDataSecret(String group) {
        if ("G1".equalsIgnoreCase(group)) {
            return this.getDataSecretG1();
        } else {
            return this.getDataSecretG1();
        }
    }
}
