package com.oyl.cics.web.data;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(path="/hello")
    public String hello() {
        return "HelloWorld";
    }

    @RequestMapping(path="/people/{age}/{name}")
    public People people(@PathVariable int age, @PathVariable String name) {
        return new People(name, age);
    }
}
