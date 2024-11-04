package com.oyl.cics.web.pidaimeicaiyang;

import com.oyl.cics.model.pidaimeicaiyang.PidaimeicaiyangRepos;
import com.oyl.cics.model.pidaimeicaiyang.request.SearchCondition;
import com.oyl.cics.model.pidaimeicaiyang.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PidaimeicaiyangController {
    private static final Logger log = LoggerFactory.getLogger(PidaimeicaiyangController.class);

    @Resource
    private PidaimeicaiyangRepos pidaimeicaiyangRepos;

    @PostMapping("/pidaimeicaiyang/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(pidaimeicaiyangRepos.search(condition));
    }
}
