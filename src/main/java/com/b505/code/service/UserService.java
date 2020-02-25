package com.b505.code.service;

import com.b505.code.entity.User;

/**
 * Created by feire on 2020/2/25.
 */
public interface UserService {

    User findByUsername(String username);
}
