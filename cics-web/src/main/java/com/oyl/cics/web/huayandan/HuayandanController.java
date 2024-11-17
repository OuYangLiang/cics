package com.oyl.cics.web.huayandan;

import com.oyl.cics.model.huayandan.Huayandan;
import com.oyl.cics.model.huayandan.HuayandanRepos;
import com.oyl.cics.model.huayandan.HuayandanService;
import com.oyl.cics.model.huayandan.request.SearchCondition;
import com.oyl.cics.model.huayandan.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.huayandan.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class HuayandanController {
    private static final Logger log = LoggerFactory.getLogger(HuayandanController.class);

    @Resource
    private HuayandanRepos huayandanRepos;

    @Resource
    private HuayandanService huayandanService;

    @PostMapping("/huayandan/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(huayandanRepos.search(condition));
    }

    @PostMapping("/huayandan/upload")
    public RestResult<Boolean> upload(@RequestBody UploadRequest request) {
        List<Huayandan> huayandans = huayandanRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            return RestResult.ok(huayandanService.upload(huayandans, request.getOperator()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
