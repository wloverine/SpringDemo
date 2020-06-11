package com.jkl.test.userMod.controller;

import com.jkl.test.userMod.service.UserService;
import com.jkl.test.userMod.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Daryl on 2020/06/10 17:16
 */
@Controller
public class UserController {

    @Autowired
    public UserService userService;

    public void addUser(){
        userService.addUser();
    }

    public UserController() {
        System.out.println("userController");
    }
}
