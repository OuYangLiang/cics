package com.oyl.cics.web.meicaiyang;

import com.oyl.cics.model.meicaiyang.MeicaiyangRepos;
import com.oyl.cics.model.meicaiyang.request.SearchCondition;
import com.oyl.cics.model.meicaiyang.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MeicaiyangController {
    private static final Logger log = LoggerFactory.getLogger(MeicaiyangController.class);

    @Resource
    private MeicaiyangRepos meicaoyangRepos;

    @PostMapping("/meicaiyang/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(meicaoyangRepos.search(condition));
    }
}
