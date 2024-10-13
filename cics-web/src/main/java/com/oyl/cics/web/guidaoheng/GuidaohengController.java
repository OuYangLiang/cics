package com.oyl.cics.web.guidaoheng;

import com.oyl.cics.model.guidaoheng.request.SearchCondition;
import com.oyl.cics.model.guidaoheng.response.SearchResult;
import com.oyl.cics.model.guidaoheng.GuidaohengRepos;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GuidaohengController {
    private static final Logger log = LoggerFactory.getLogger(GuidaohengController.class);

    @Resource
    private GuidaohengRepos guidaohengRepos;

    @PostMapping("/guidaoheng/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(guidaohengRepos.search(condition));
    }
}
