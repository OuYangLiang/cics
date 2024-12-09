package com.oyl.cics.web.common.job;

import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengRepos;
import com.oyl.cics.model.guidaoheng.GuidaohengService;
import com.oyl.cics.model.huayandan.Huayandan;
import com.oyl.cics.model.huayandan.HuayandanRepos;
import com.oyl.cics.model.huayandan.HuayandanService;
import com.oyl.cics.model.kjhuayandan.Kjhuayandan;
import com.oyl.cics.model.kjhuayandan.KjhuayandanRepos;
import com.oyl.cics.model.kjhuayandan.KjhuayandanService;
import com.oyl.cics.model.meicaiyang.Meicaiyang;
import com.oyl.cics.model.meicaiyang.MeicaiyangRepos;
import com.oyl.cics.model.meicaiyang.MeicaiyangService;
import com.oyl.cics.model.meizhi.Meizhi;
import com.oyl.cics.model.meizhi.MeizhiRepos;
import com.oyl.cics.model.meizhi.MeizhiService;
import com.oyl.cics.model.pidaimeicaiyang.Pidaimeicaiyang;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangRepos;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangService;
import com.oyl.cics.model.qichecheng.Qichecheng;
import com.oyl.cics.model.qichecheng.QichechengRepos;
import com.oyl.cics.model.qichecheng.QichechengService;
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

    @Resource
    private QichechengRepos qichechengRepos;

    @Resource
    private QichechengService qichechengService;

    @Resource
    private MeicaiyangRepos meicaiyangRepos;

    @Resource
    private MeicaiyangService meicaiyangService;

    @Resource
    private PidaimeicaiyangRepos pidaimeicaiyangRepos;
    @Resource
    private PidaimeicaiyangService pidaimeicaiyangService;

    @Resource
    private MeizhiRepos meizhiRepos;

    @Resource
    private MeizhiService meizhiService;

    @Resource
    private HuayandanRepos huayandanRepos;

    @Resource
    private HuayandanService huayandanService;

    @Resource
    private KjhuayandanRepos kjhuayandanRepos;

    @Resource
    private KjhuayandanService kjhuayandanService;

    @Scheduled(cron = "0 5/35 * * * ?")
    private void configureTasks() {
        log.info("拉数任务开始执行...");

        try {
            log.info("拉取轨道衡数据");
            this.guidaoheng();
            log.info("轨道衡数据结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            log.info("拉取汽车衡数据");
            this.qichecheng();
            log.info("汽车衡数据结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            log.info("拉取煤采样数据");
            this.meicaiyang();
            log.info("煤采样数据结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            log.info("拉取皮带煤采样数据");
            this.pidaimeicaiyang();
            log.info("皮带煤采样数据结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            log.info("拉取煤质数据");
            this.meizhi();
            log.info("煤质数据结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            log.info("拉取化验单数据");
            this.huayandan();
            log.info("化验单数据结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        try {
            log.info("拉取快检化验单数据");
            this.kjhuayandan();
            log.info("快检化验单数据结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }



        log.info("拉数任务执行结束...");
    }

    private void guidaoheng() {
        List<Guidaoheng> list = guidaohengRepos.queryFromOldSystem();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Guidaoheng item : list) {
                try {
                    guidaohengService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    private void qichecheng() {
        List<Qichecheng> list = qichechengRepos.queryFromOldSystem();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Qichecheng item : list) {
                try {
                    qichechengService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    private void meicaiyang() {
        List<Meicaiyang> list = meicaiyangRepos.queryFromOldSystem();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Meicaiyang item : list) {
                try {
                    meicaiyangService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    private void pidaimeicaiyang() {
        List<Pidaimeicaiyang> list = pidaimeicaiyangRepos.queryFromOldSystem();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Pidaimeicaiyang item : list) {
                try {
                    pidaimeicaiyangService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    private void meizhi() {
        List<Meizhi> list = meizhiRepos.queryFromOldSystem();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Meizhi item : list) {
                try {
                    meizhiService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    private void huayandan() {
        List<Huayandan> list = huayandanRepos.queryFromOldSystem();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Huayandan item : list) {
                try {
                    huayandanService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    private void kjhuayandan() {
        List<Kjhuayandan> list = kjhuayandanRepos.queryFromOldSystem();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Kjhuayandan item : list) {
                try {
                    kjhuayandanService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }
}
