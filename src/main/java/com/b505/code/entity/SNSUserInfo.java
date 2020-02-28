package com.b505.code.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by feire on 2020/2/25.
 */
@Data
@Entity
@Table(name = "user0" )
public class SNSUserInfo {
    public SNSUserInfo(String openId, String nickname, int sex, String country,
                String province, String city, String headImgUrl,
                List<String> privilegeList){
        super();
        this.openId = openId;
        this.nickname = nickname;
        this.sex = sex;
        this.country = country;
        this.province = province;
        this.city = city;
        this.headImgUrl = headImgUrl;
        this.privilegeList = privilegeList;
    }
    public SNSUserInfo(){

    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String openId;
    @Column
    private String nickname;
    //性别 （1男2女3未知）
    @Column
    private int sex;
    @Column
    private String country;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String headImgUrl;
    @Column
    @ElementCollection
    private List<String> privilegeList;

}

