package com.oyl.cics.web.kjhuayandan;

import com.oyl.cics.model.kjhuayandan.Kjhuayandan;
import com.oyl.cics.model.kjhuayandan.request.SearchCondition;
import com.oyl.cics.model.kjhuayandan.response.SearchResult;
import com.oyl.cics.model.kjhuayandan.KjhuayandanRepos;
import com.oyl.cics.model.kjhuayandan.KjhuayandanService;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.kjhuayandan.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class KjhuayandanController {
    private static final Logger log = LoggerFactory.getLogger(KjhuayandanController.class);

    @Resource
    private KjhuayandanRepos kjhuayandanRepos;

    @Resource
    private KjhuayandanService kjhuayandanService;

    @PostMapping("/kjhuayandan/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(kjhuayandanRepos.search(condition));
    }

    @PostMapping("/kjhuayandan/upload")
    public RestResult<Boolean> upload(@RequestBody UploadRequest request) {
        List<Kjhuayandan> huayandans = kjhuayandanRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            return RestResult.ok(kjhuayandanService.upload(huayandans, request.getOperator()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
