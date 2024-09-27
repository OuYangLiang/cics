package com.oyl.cics.web.login;

import com.oyl.cics.web.common.result.RestResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @RequestMapping(path="/login")
    public RestResult<LoginRequest> login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
        return RestResult.ok(loginRequest);
    }

}
