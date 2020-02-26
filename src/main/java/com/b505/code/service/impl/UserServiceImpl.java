package com.b505.code.service.impl;

import com.b505.code.dao.UserDao;
import com.b505.code.entity.SNSUserInfo;

import com.b505.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by feire on 2020/2/25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;
    @Override
    public void addUser(SNSUserInfo user) {
        userDao.save(user);
    }

    @Override
    public SNSUserInfo updateUser(SNSUserInfo user) {
        return null;
    }

    @Override
    public SNSUserInfo deleteUser(int id) {
        return null;
    }

    @Override
    public SNSUserInfo getUser(int id) {
        return null;
    }

    @Override
    public List<SNSUserInfo> getUsers() {
        return null;
    }
}
