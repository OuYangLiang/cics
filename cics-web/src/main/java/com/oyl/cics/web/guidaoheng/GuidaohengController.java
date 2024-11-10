package com.oyl.cics.web.guidaoheng;

import com.oyl.cics.model.common.cfg.PropertiesConfig;

import com.oyl.cics.model.common.utils.http.Result;
import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengService;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;
import com.oyl.cics.model.guidaoheng.response.SearchResult;
import com.oyl.cics.model.guidaoheng.GuidaohengRepos;
import com.oyl.cics.model.huayandan.Huayandan;
import com.oyl.cics.model.huayandan.HuayandanRepos;
import com.oyl.cics.model.huayandan.HuayandanService;
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
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.guidaoheng.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class GuidaohengController {
    private static final Logger log = LoggerFactory.getLogger(GuidaohengController.class);

    @Resource
    private GuidaohengRepos guidaohengRepos;

    @Resource
    private GuidaohengService guidaohengService;

    @PostMapping("/guidaoheng/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(guidaohengRepos.search(condition));
    }

    @PostMapping("/guidaoheng/upload")
    public RestResult<Result> upload(@RequestBody UploadRequest request) {
        List<Guidaoheng> guidaohengs = guidaohengRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            Result result = guidaohengService.upload(guidaohengs, request.getOperator());
            return RestResult.ok(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Resource
    private PropertiesConfig propertiesConfig;

    @GetMapping("/guidaoheng/test/{id}")
    public RestResult<Guidaoheng> test(@PathVariable int id) {
        log.info("DataPullingJob Started...");
        if (1 == id) {
            this.guidaoheng();
        } else if (2 == id) {
            this.qichecheng();
        } else if (3 == id) {
            this.meicaiyang();
        } else if (4 == id) {
            this.pidaimeicaiyang();
        } else if (5 == id) {
            this.meizhi();
        }
        log.info("DataPullingJob Ended...");
        return RestResult.ok(null);
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

    @Resource
    private QichechengRepos qichechengRepos;
    @Resource
    private QichechengService qichechengService;

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

    @Resource
    private MeicaiyangRepos meicaiyangRepos;
    @Resource
    private MeicaiyangService meicaiyangService;

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

    @Resource
    private PidaimeicaiyangRepos pidaimeicaiyangRepos;
    @Resource
    private PidaimeicaiyangService pidaimeicaiyangService;

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

    @Resource
    private MeizhiRepos meizhiRepos;
    @Resource
    private MeizhiService meizhiService;

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

    @Resource
    private HuayandanRepos huayandanRepos;
    @Resource
    private HuayandanService huayandanService;

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
}
