package com.oyl.cics.web.user;


import com.oyl.cics.model.user.UserRepos;
import com.oyl.cics.model.user.request.SearchCondition;
import com.oyl.cics.model.user.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserRepos userRepos;

    @PostMapping("/user/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(userRepos.search(condition));
    }
}
