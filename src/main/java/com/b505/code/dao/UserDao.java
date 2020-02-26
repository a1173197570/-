package com.b505.code.dao;

import com.b505.code.entity.SNSUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by feire on 2020/2/25.
 */

@Repository
public interface UserDao extends JpaRepository<SNSUserInfo, Integer> {

}