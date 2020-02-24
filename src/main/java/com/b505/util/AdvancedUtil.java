package com.b505.util;

import java.awt.*;

import com.b505.code.entity.WeiXinUser;
import com.b505.pojo.WeixinOauth2Token;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AdvancedUtil {

    public static Logger logger= LoggerFactory.getLogger(AdvancedUtil.class);

    /**
     * 获取网页授权凭证
     * @param  appId  公众号的唯一标识
     * @param appSecret  公众号的密钥
     * @param code
     * @return WeixinOauth2Token
     */
    public static WeixinOauth2Token getOauth2Token(String appId,String appSecret,String code){

        String requestUrl="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

        requestUrl=requestUrl.replace("APPID",appId);
        requestUrl=requestUrl.replace("SECRET",appSecret);
        requestUrl=requestUrl.replace("CODE",code);

        WeixinOauth2Token wat=null;

        //获取网页授权的凭证
        JSONObject jsonObject=JsapiTicketUnit.httpRequest(requestUrl,"GET",null);

        if(null!=jsonObject){

            try {

                wat=new WeixinOauth2Token();
                wat.setAccessToken(jsonObject.getString("access_token"));
                wat.setExpiresIn(jsonObject.getInt("expires_in"));
                wat.setOpenId(jsonObject.getString("openid"));
                wat.setRefreshToken(jsonObject.getString("refresh_token"));
                wat.setScope(jsonObject.getString("scope"));
            }catch (Exception e){

                wat=null;
                int errorCode=jsonObject.getInt("errcode");
                String errorMsg=jsonObject.getString("errmsg");
                logger.error("获取网页授权失败",errorCode,errorMsg);
            }

        }


        return wat;
    }


    /**
     * 通过网页授权获取用户的信息
     * @param accessToken
     * @param openId
     *
     */
    public static WeiXinUser getWeiXinUser(String accessToken,String openId){

        //拼接请求的地址
        String requestUrl="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

        requestUrl=requestUrl.replace("ACCESS_TOKEN",accessToken).replace("OPENID",openId);

        //获取网页授权的凭证
        JSONObject jsonObject=JsapiTicketUnit.httpRequest(requestUrl,"GET",null);

        WeiXinUser weiXinUser=null;

        if(null!=jsonObject){


            try {

                weiXinUser=new WeiXinUser();
                //用户的标识
                weiXinUser.setOpenId(jsonObject.getString("openid"));
                //昵称
                weiXinUser.setNickname(jsonObject.getString("nickname"));
                //性别（1是男 2是女 0是未知）
                weiXinUser.setSex(jsonObject.getInt("sex"));
                //用户所在的国家
                weiXinUser.setCountry(jsonObject.getString("country"));
                //用户所在的省份
                weiXinUser.setProvince(jsonObject.getString("province"));
                //用户所在的城市
                weiXinUser.setCity(jsonObject.getString("city"));
                //用户的头像
                weiXinUser.setHeadImgUrl(jsonObject.getString("headimgurl"));
                //用户的特权信息
                /* weiXinUser.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));*/

            }catch (Exception e){

                weiXinUser=null;
                int errorCode=jsonObject.getInt("errcode");
                String errorMsg=jsonObject.getString("errmsg");
                logger.error("获取用户信息失败",errorCode,errorMsg);

            }


        }

        return weiXinUser;

    }



}
