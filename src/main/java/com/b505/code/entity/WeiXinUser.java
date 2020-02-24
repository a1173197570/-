package com.b505.code.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by feire on 2020/2/21.
 */
@Data
public class WeiXinUser {

    //用户标识
    private String openId;
    //用户昵称
    private String nickname;
    //性别 （1是男性 2是女性 3是未知）
    private int sex;
    //国家
    private String country;
    //省份
    private String province;
    //城市
    private String city;
    //用户头像链接
    private String headImgUrl;
    //用户特权信息
    private List<String> privilegeList;


}
