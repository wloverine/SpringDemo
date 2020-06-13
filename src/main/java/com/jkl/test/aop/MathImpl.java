package com.jkl.test.aop;

import org.springframework.stereotype.Component;

/**
 * Created by Daryl on 2020/06/12 15:13
 */
@Component
public class MathImpl implements MathI {

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }

    @Override
    public void hh(int a, int b) {
        System.out.println(a+b);
    }


}
