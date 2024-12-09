package com.oyl.cics.web.pidaimeicaiyang;

import com.oyl.cics.model.pidaimeicaiyang.Pidaimeicaiyang;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangRepos;
import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangService;
import com.oyl.cics.model.pidaimeicaiyang.request.SearchCondition;
import com.oyl.cics.model.pidaimeicaiyang.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.pidaimeicaiyang.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class PidaimeicaiyangController {
    private static final Logger log = LoggerFactory.getLogger(PidaimeicaiyangController.class);

    @Resource
    private PidaimeicaiyangRepos pidaimeicaiyangRepos;

    @Resource
    private PidaimeicaiyangService pidaimeicaiyangService;

    @PostMapping("/pidaimeicaiyang/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(pidaimeicaiyangRepos.search(condition));
    }

    @PostMapping("/pidaimeicaiyang/upload")
    public RestResult<Boolean> upload(@RequestBody UploadRequest request) {
        List<Pidaimeicaiyang> pidaimeicaiyangs = pidaimeicaiyangRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            return RestResult.ok(pidaimeicaiyangService.upload(pidaimeicaiyangs, request.getOperator()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/pidaimeicaiyang/sync")
    public RestResult<Integer> sync() {
        List<Pidaimeicaiyang> list = pidaimeicaiyangRepos.queryFromOldSystem();
        int result = list == null ? 0 : list.size();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Pidaimeicaiyang item : list) {
                try {
                    pidaimeicaiyangService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    result --;
                }
            }
        }

        return RestResult.ok(result);
    }
}
