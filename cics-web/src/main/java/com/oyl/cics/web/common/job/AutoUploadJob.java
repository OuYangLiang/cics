package com.oyl.cics.web.common.job;

import com.oyl.cics.model.guidaoheng.GuidaohengService;
import com.oyl.cics.model.huayandan.HuayandanService;
import com.oyl.cics.model.kjhuayandan.KjhuayandanService;
import com.oyl.cics.model.meicaiyang.MeicaiyangService;
import com.oyl.cics.model.meizhi.MeizhiService;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangService;
import com.oyl.cics.model.qichecheng.QichechengService;
import com.oyl.cics.model.setting.SettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration
@EnableScheduling
public class AutoUploadJob {
    private static final Logger log = LoggerFactory.getLogger(AutoUploadJob.class);

    @Resource
    private GuidaohengService guidaohengService;
    @Resource
    private QichechengService qichechengService;
    @Resource
    private MeicaiyangService meicaiyangService;
    @Resource
    private PidaimeicaiyangService pidaimeicaiyangService;
    @Resource
    private MeizhiService meizhiService;
    @Resource
    private HuayandanService huayandanService;
    @Resource
    private KjhuayandanService kjhuayandanService;

    @Resource
    private SettingService settingService;

    @Scheduled(cron = "0 0 8 * * ?")
    private void configureTasks() {

        if (!settingService.autoUpload()) {
            return;
        }

        log.info("自动上传任务开始执行");

        try {
            guidaohengService.autoUpload();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            qichechengService.autoUpload();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            meicaiyangService.autoUpload();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            pidaimeicaiyangService.autoUpload();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            meizhiService.autoUpload();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            huayandanService.autoUpload();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            kjhuayandanService.autoUpload();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        log.info("自动上传任务执行结束");
    }
}
