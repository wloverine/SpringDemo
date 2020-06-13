package com.jkl.test.aop;

import org.springframework.stereotype.Component;

/**
 * Created by Daryl on 2020/06/12 16:17
 */
@Component
public class TestHandler {
    public void test(){
        System.out.println("测试切面表达式");
    }
}
