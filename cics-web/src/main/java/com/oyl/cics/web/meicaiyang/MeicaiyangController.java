package com.oyl.cics.web.meicaiyang;

import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.meicaiyang.Meicaiyang;
import com.oyl.cics.model.meicaiyang.MeicaiyangRepos;
import com.oyl.cics.model.meicaiyang.MeicaiyangService;
import com.oyl.cics.model.meicaiyang.request.SearchCondition;
import com.oyl.cics.model.meicaiyang.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.meicaiyang.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class MeicaiyangController {
    private static final Logger log = LoggerFactory.getLogger(MeicaiyangController.class);

    @Resource
    private MeicaiyangRepos meicaiyangRepos;

    @Resource
    private MeicaiyangService meicaiyangService;

    @PostMapping("/meicaiyang/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(meicaiyangRepos.search(condition));
    }

    @PostMapping("/meicaiyang/upload")
    public RestResult<Boolean> upload(@RequestBody UploadRequest request) {
        List<Meicaiyang> meicaiyangs = meicaiyangRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            return RestResult.ok(meicaiyangService.upload(meicaiyangs, request.getOperator()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/meicaiyang/sync")
    public RestResult<Integer> sync() {
        List<Meicaiyang> list = meicaiyangRepos.queryFromOldSystem();
        int result = list == null ? 0 : list.size();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Meicaiyang item : list) {
                try {
                    meicaiyangService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    result --;
                }
            }
        }

        return RestResult.ok(result);
    }
}
