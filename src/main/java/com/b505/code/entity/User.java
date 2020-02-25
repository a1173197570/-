package com.b505.code.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by feire on 2020/2/25.
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "a_native")
    // 指定主键生成策略，默认为自增
    @GenericGenerator(name = "a_native", strategy = "native")
    private int id;
    private String username;
    private String password;
    private String  email;
    private String picture;
    private String turename;

    //省略get set 方法

    @Override
    public  String toString(){

        return "username="+username+" password="+password+"turename"+turename+"picture"+picture;

    }
}
