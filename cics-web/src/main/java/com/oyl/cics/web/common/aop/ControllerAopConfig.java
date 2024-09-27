package com.oyl.cics.web.common.aop;

import com.oyl.cics.web.common.result.RestResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class ControllerAopConfig {

    @Pointcut("execution(com.oyl.cics.web.common.result.RestResult com.oyl.cics.web.*.*Controller.*(..))")
    public void controller() {
    }

    @Around("controller()")
    public Object aroundController(final ProceedingJoinPoint pjp) throws Throwable {

        for (Object args : pjp.getArgs()) {
            if (args instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) args;
                if (bindingResult.hasErrors()) {
                    return RestResult.fail("1", bindingResult.getAllErrors().get(0).getDefaultMessage());
                }
            }
        }

        return pjp.proceed();
    }
}
