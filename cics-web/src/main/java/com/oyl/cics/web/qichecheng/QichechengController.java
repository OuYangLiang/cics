package com.oyl.cics.web.qichecheng;

import com.oyl.cics.model.qichecheng.Qichecheng;
import com.oyl.cics.model.qichecheng.QichechengService;
import com.oyl.cics.model.qichecheng.request.SearchCondition;
import com.oyl.cics.model.qichecheng.response.SearchResult;
import com.oyl.cics.model.qichecheng.QichechengRepos;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.qichecheng.request.UploadRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
public class QichechengController {
    private static final Logger log = LoggerFactory.getLogger(QichechengController.class);

    @Resource
    private QichechengRepos qichechengRepos;

    @Resource
    private QichechengService qichechengService;

    @PostMapping("/qichecheng/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(qichechengRepos.search(condition));
    }

    @PostMapping("/qichecheng/upload")
    public RestResult<Boolean> upload(@RequestBody UploadRequest request) {
        List<Qichecheng> qichechengs = qichechengRepos.queryByKeys(Arrays.stream(request.getIds()).mapToLong(Long::longValue).toArray());

        try {
            return RestResult.ok(qichechengService.upload(qichechengs, request.getOperator()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/meicaiyang/sync")
    public RestResult<Integer> sync() {
        List<Qichecheng> list = qichechengRepos.queryFromOldSystem();
        int result = list == null ? 0 : list.size();
        if (null != list) {
            log.info("{} Records found.", list.size());
            for (Qichecheng item : list) {
                try {
                    qichechengService.override(item);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                    result --;
                }
            }
        }

        return RestResult.ok(result);
    }
}
