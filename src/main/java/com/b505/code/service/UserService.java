package com.b505.code.service;

import com.b505.code.entity.SNSUserInfo;


import java.util.List;

/**
 * Created by feire on 2020/2/25.
 */


public interface UserService {
    //添加用户
    public void addUser(SNSUserInfo user);
    //修改用户
    public SNSUserInfo updateUser(SNSUserInfo user);
    //删除用户,根据用户编号删除
    public SNSUserInfo deleteUser(int id) ;
    //查询单个用户
    public SNSUserInfo getUser(int id);
    //查询所有用户
    public List<SNSUserInfo> getUsers();
}
