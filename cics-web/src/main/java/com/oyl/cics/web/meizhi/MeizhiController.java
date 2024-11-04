package com.oyl.cics.web.meizhi;

import com.oyl.cics.model.common.utils.http.Result;
import com.oyl.cics.model.meizhi.Meizhi;
import com.oyl.cics.model.meizhi.MeizhiRepos;
import com.oyl.cics.model.meizhi.MeizhiService;
import com.oyl.cics.model.meizhi.request.SearchCondition;
import com.oyl.cics.model.meizhi.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.meizhi.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class MeizhiController {
    private static final Logger log = LoggerFactory.getLogger(MeizhiController.class);

    @Resource
    private MeizhiRepos meizhiRepos;

    @Resource
    private MeizhiService meizhiService;

    @PostMapping("/meizhi/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(meizhiRepos.search(condition));
    }

    @PostMapping("/meizhi/upload")
    public RestResult<Result> upload(@RequestBody UploadRequest request) {
        List<Meizhi> meizhis = meizhiRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            Result result = meizhiService.upload(meizhis, request.getOperator());
            return RestResult.ok(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
