package com.oyl.cics.web.user;


import com.oyl.cics.model.user.User;
import com.oyl.cics.model.user.UserRepos;
import com.oyl.cics.model.user.request.CreateRequest;
import com.oyl.cics.model.user.request.RemoveRequest;
import com.oyl.cics.model.user.request.SearchCondition;
import com.oyl.cics.model.user.response.SearchResult;
import com.oyl.cics.web.common.result.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserRepos userRepos;

    @PostMapping("/user/search")
    public RestResult<SearchResult> search(@RequestBody SearchCondition condition) {
        return RestResult.ok(userRepos.search(condition));
    }

    @PostMapping("/user/create")
    public RestResult<User> create(@RequestBody @Valid @NotNull(message = "请求对象不能为空") CreateRequest createRequest, BindingResult bindingResult) {
        User user = userRepos.create(createRequest);
        return RestResult.ok(user);
    }

    @PostMapping("/user/remove")
    public RestResult<Void> remove(@RequestBody @Valid @NotNull(message = "请求对象不能为空") RemoveRequest request, BindingResult bindingResult) {
        userRepos.remove(request);
        return RestResult.ok();
    }
}
