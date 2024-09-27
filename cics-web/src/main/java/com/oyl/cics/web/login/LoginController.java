package com.oyl.cics.web.login;

import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.common.util.JwtUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @RequestMapping(path="/login")
    public RestResult<String> login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
        if ("OYL".equals(loginRequest.getUsername()) && "pwd123".equals(loginRequest.getPassword())) {
            return RestResult.ok(JwtUtil.instance.createToken(loginRequest.getUsername()));
        }

        return RestResult.fail("1", "用户名 或 密码 不正确");
    }

}
