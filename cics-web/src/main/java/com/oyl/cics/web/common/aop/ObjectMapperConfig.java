package com.oyl.cics.web.common.aop;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class ObjectMapperConfig {
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder, JacksonProperties jacksonProperties) {
        ObjectMapper objectMapper = builder.build();

        // 将不匹配的enum转为null，防止报错
        objectMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
        return objectMapper;
    }
}
