package com.oyl.cics.web.login;

import com.oyl.cics.model.user.User;
import com.oyl.cics.model.user.UserRepos;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.common.util.JwtUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class LoginController {

    @Resource
    private UserRepos userRepos;

    @RequestMapping(path="/login")
    public RestResult<String> login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {

        User user = userRepos.queryByUsername(loginRequest.getUsername());

        if (null == user || !user.getPassword().equals(loginRequest.getPassword())) {
            return RestResult.fail("1", "用户名 或 密码 不正确");
        }

        return RestResult.ok(JwtUtil.instance.createToken(loginRequest.getUsername()));
    }

}
