package com.b505.pojo;

import lombok.Data;

/**
 * Created by feire on 2020/2/21.
 */
@Data
public class WeixinOauth2Token {
    //网页授权接口调用凭证
    private String accessToken;
    //凭证有效时间
    private int expiresIn;
    //用于刷新凭证
    private String refreshToken;
    //用户标识
    private String openId;
    //用户授权作用域
    private String scope;

    @Override
    public String toString(){

        return "accessToken="+accessToken;
    }
}
