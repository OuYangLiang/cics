package com.oyl.cics.web.meizhi;

import com.oyl.cics.model.meizhi.MeizhiRepos;
import com.oyl.cics.model.meizhi.request.SearchCondition;
import com.oyl.cics.model.meizhi.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MeizhiController {
    private static final Logger log = LoggerFactory.getLogger(MeizhiController.class);

    @Resource
    private MeizhiRepos meizhiRepos;

    @PostMapping("/meizhi/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(meizhiRepos.search(condition));
    }
}
