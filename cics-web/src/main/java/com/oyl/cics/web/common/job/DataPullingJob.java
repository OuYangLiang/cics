package com.oyl.cics.web.common.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DataPullingJob {

    private static final Logger log = LoggerFactory.getLogger(DataPullingJob.class);

    @Scheduled(cron = "0/5 * * * * ?")
    private void configureTasks() {
        log.info("执行静态定时任务时间");
    }
}
