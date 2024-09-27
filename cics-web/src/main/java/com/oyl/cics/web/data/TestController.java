package com.oyl.cics.web.data;

import com.oyl.cics.web.common.result.RestResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(path="/people/{age}/{name}")
    public RestResult<People> people(@PathVariable int age, @PathVariable String name) {
        return RestResult.ok(new People(name, age));
    }
}
