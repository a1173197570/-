package com.b505.code.controller;

/**
 * Created by feire on 2020/2/21.
 */
import com.b505.code.entity.WeiXinUser;
import com.b505.pojo.WeixinOauth2Token;
import com.b505.util.AdvancedUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;


@Controller
public class WeiXinController {

    /**
     * 跳转页面 进行网页授权
     */
    @RequestMapping("/text1")
    public String text(HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {

        request.setCharacterEncoding("gb2312");
        response.setCharacterEncoding("gb2312");

        //用户同意授权
        String code =request.getParameter("code");

        //用户同意授权要跳转的页面
        if(!"authdeny".equals(code)){

            WeixinOauth2Token weixinOauth2Token= AdvancedUtil.getOauth2Token("","",code);

            //网页授权凭证
            String accessToken=weixinOauth2Token.getAccessToken();
            //用户的标识
            String openId=weixinOauth2Token.getOpenId();

            WeiXinUser weiXinUser=AdvancedUtil.getWeiXinUser(accessToken,openId);

            System.out.println("-------------------------------"+weiXinUser.getOpenId());
            System.out.println(weiXinUser.toString());


            //将weiXinUser保存在数据库里面，或者于数据库里面的信息进行比对，看看是否存在。


            return "index";

        }

        //用户不同意授权的页面
        return "error";


    }




}
