package com.oyl.cics.web.qichecheng;

import com.oyl.cics.model.qichecheng.request.SearchCondition;
import com.oyl.cics.model.qichecheng.response.SearchResult;
import com.oyl.cics.model.qichecheng.QichechengRepos;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class QichechengController {
    private static final Logger log = LoggerFactory.getLogger(QichechengController.class);

    @Resource
    private QichechengRepos qichechengRepos;

    @PostMapping("/qichecheng/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(qichechengRepos.search(condition));
    }
}
