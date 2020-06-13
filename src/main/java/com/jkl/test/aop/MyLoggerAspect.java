package com.jkl.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by Daryl on 2020/06/12 15:27
 */
@Component
@Aspect
public class MyLoggerAspect {
    @Before(value = "execution(* com.jkl.test.aop.*.*(..))")
    public void beforeMethod(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String name = jp.getSignature().getName();
        System.out.println(MessageFormat.format("method is {0},arguments:{1}", name, Arrays.toString(args)));
    }

    @After(value = "execution(* com.jkl.test.aop.*.*(..))")
    public void afterMethod() {
        System.out.println("后置通知");
    }

    @AfterReturning(value = "execution(* com.jkl.test.aop.*.*(..))", returning = "result")
    public void returnMethod(Object result) {
        System.out.println("The result is : " + result);
    }

    @AfterThrowing(value = "execution(* com.jkl.test.aop.*.*(..))",throwing = "ex")
    public void exceptionMethod(Exception ex){
        System.out.println(ex);
    }

}
