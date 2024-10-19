package com.oyl.cics.web.guidaoheng;

import com.oyl.cics.model.guidaoheng.Guidaoheng;
import com.oyl.cics.model.guidaoheng.GuidaohengService;
import com.oyl.cics.model.guidaoheng.request.SearchCondition;
import com.oyl.cics.model.guidaoheng.response.SearchResult;
import com.oyl.cics.model.guidaoheng.GuidaohengRepos;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.guidaoheng.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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
    public RestResult<Void> upload(@RequestBody UploadRequest request) {
        List<Guidaoheng> guidaohengs = guidaohengRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            guidaohengService.upload(guidaohengs, request.getOperator());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return RestResult.ok(null);
    }
}
