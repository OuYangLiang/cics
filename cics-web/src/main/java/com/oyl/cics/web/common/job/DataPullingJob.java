package com.oyl.cics.web.common.job;

import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengRepos;
import com.oyl.cics.model.guidaoheng.GuidaohengService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class DataPullingJob {

    private static final Logger log = LoggerFactory.getLogger(DataPullingJob.class);

    @Resource
    private GuidaohengRepos guidaohengRepos;

    @Resource
    private GuidaohengService guidaohengService;

//    @Scheduled(cron = "0/30 * * * * ?")
    private void configureTasks() {
        log.info("DataPullingJob Started...");

        List<Guidaoheng> list = guidaohengRepos.queryFromOldSystem();

        if (null != list) {
            log.info("{} Records found.", list.size());

            for (Guidaoheng item : list) {
                guidaohengService.override(item);
            }
        }

        log.info("DataPullingJob Ended...");
    }
}
