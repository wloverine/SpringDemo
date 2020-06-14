package com.jkl.test.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class TestAspect {
    @Before(value = "execution(* com.jkl.test.aop.*.*(..))")
    public void before(){
        System.out.println("test => before");
    }
}
