package com.jkl.test.userMod.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Daryl on 2020/06/10 17:20
 */
@Repository
public class UserDaoImpl implements UserDao {
    public  UserDaoImpl(){
        System.out.println("UserDaoImpl");
    }

    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
