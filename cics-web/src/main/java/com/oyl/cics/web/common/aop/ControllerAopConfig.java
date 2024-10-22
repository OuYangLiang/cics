package com.oyl.cics.web.common.aop;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.oyl.cics.web.common.result.RestResult;
import com.oyl.cics.web.common.util.JwtUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerAopConfig {
    private static final Logger log = LoggerFactory.getLogger(ControllerAopConfig.class);

    @Pointcut("execution(com.oyl.cics.web.common.result.RestResult com.oyl.cics.web.*.*Controller.*(..))")
    public void controller() {
    }

    @Around("controller()")
    public Object aroundController(final ProceedingJoinPoint pjp) throws Throwable {

        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attrs != null;
        HttpServletRequest request = attrs.getRequest();

        if (!"/guidaoheng/test".equals(request.getRequestURI()) && !"/login".equals(request.getRequestURI())) {
            // 校验是否登录
            String token = request.getHeader("Authorization");
            if (null == token) {
                return RestResult.fail("0", "未登录");
            }

            try {
                String username = JwtUtil.instance.verify(token);
            } catch (JWTVerificationException e) {
                return RestResult.fail("0", e.getMessage());
            }
        }

        for (Object args : pjp.getArgs()) {
            if (args instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) args;
                if (bindingResult.hasErrors()) {
                    return RestResult.fail("1", bindingResult.getAllErrors().get(0).getDefaultMessage());
                }
            }
        }

        try {
            return pjp.proceed();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return RestResult.fail("1", e.getMessage());
        }
    }
}
