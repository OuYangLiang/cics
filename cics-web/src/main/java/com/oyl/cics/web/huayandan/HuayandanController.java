package com.oyl.cics.web.huayandan;

import com.oyl.cics.model.huayandan.HuayandanRepos;
import com.oyl.cics.model.huayandan.request.SearchCondition;
import com.oyl.cics.model.huayandan.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HuayandanController {
    private static final Logger log = LoggerFactory.getLogger(HuayandanController.class);

    @Resource
    private HuayandanRepos huayandanRepos;

    @PostMapping("/huayandan/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(huayandanRepos.search(condition));
    }
}
