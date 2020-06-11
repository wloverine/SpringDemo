package com.jkl.test.userMod.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Daryl on 2020/06/11 16:03
 */
@Repository
public class UserMyBatisImpl implements UserDao{

    @Override
    public void addUser() {
        System.out.println("UserMyBatisImpl:添加用户成功");
    }
}
