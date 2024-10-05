package com.oyl.cics.model.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Method;
import java.util.Set;

@Aspect
@Component
public class AopConfig {
    @Pointcut("@annotation(com.oyl.cics.model.common.validation.ValidParam)")
    public void validParam() {
    }

    @Around("validParam()")
    public Object aroundValidParam(final ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Set<ConstraintViolation<Object>> errors =
                    factory.getValidator().forExecutables().validateParameters( pjp.getTarget(), method, pjp.getArgs() );
            if (!errors.isEmpty()) {
                throw new IllegalArgumentException(errors.stream().findAny().get().getMessage());
            }
        }

        return pjp.proceed();
    }
}
