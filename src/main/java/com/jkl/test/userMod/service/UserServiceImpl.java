package com.jkl.test.userMod.service;

import com.jkl.test.userMod.dao.UserDao;
import com.jkl.test.userMod.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Daryl on 2020/06/10 17:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    public UserDao userDao;
    public UserServiceImpl(){
        System.out.println("UserServiceImpl");
    }

    @Override
    public void addUser() {
        userDao.addUser();
    }
}
