package com.jkl.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.jkl.test.aop.MathI;
import com.jkl.test.aop.MathImpl;
import com.jkl.test.aop.TestHandler;
import com.jkl.test.auto.Emp;
import com.jkl.test.bean.Student;
import com.jkl.test.bean.User;
import com.jkl.test.service.UserService;
import com.jkl.test.userMod.controller.UserController;
import com.jkl.test.userMod.dao.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by Daryl on 2020/06/04 17:30
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext cxl = new ClassPathXmlApplicationContext("aop.xml");
//        UserService userService = (UserService) cxl.getBean("userService");
//        User user = userService.login("bob@example.com", "password");
//        System.out.println(user.getName());
//        System.out.println(cxl.getClass());
//        MathI bean = cxl.getBean("mathImpl", MathI.class);
//        int res = bean.plus(1, 3);
//        System.out.println(res);
        MathI bean = cxl.getBean("mathImpl",MathI.class);
        bean.div(1,0);




    }
}
