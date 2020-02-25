package com.b505.code.service.impl;

import com.b505.code.dao.UserDao;
import com.b505.code.entity.User;
import com.b505.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by feire on 2020/2/25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {


        return userDao.findByUsername( username );
    }
}
