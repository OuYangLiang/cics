package com.oyl.cics.web.kjhuayandan;

import com.oyl.cics.model.kjhuayandan.KjhuayandanRepos;
import com.oyl.cics.model.kjhuayandan.request.SearchCondition;
import com.oyl.cics.model.kjhuayandan.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class KjhuayandanController {
    private static final Logger log = LoggerFactory.getLogger(KjhuayandanController.class);

    @Resource
    private KjhuayandanRepos kjhuayandanRepos;

    @PostMapping("/kjhuayandan/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(kjhuayandanRepos.search(condition));
    }
}
