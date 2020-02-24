package com.b505.controller;

import com.b505.config.WeiXinSignUtil;
import com.b505.service.CoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 描述：微信请求处理的核心类(
 * author：yulin
 * Create date 2020-2-7 19:57
 */
@RestController
@RequestMapping(value="/wechat"	)
public class WeixinCoreController {

    private static Logger logger = LoggerFactory.getLogger(WeixinCoreController.class);

    @Autowired
    private WeiXinSignUtil weixinSignUtil;
    /**
     * 描述: 验证请求是否来自微信服务器
     * Return: 返回微信服务器发过来的验证字符
     * author：yulin
     * Create date 2020-2-7 19:59
     */
    @GetMapping
    public String WeChatInterface(HttpServletRequest request)throws Exception{
        System.out.println("-------------验证微信服务号信息开始----------");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        logger.info("signature is :"+signature+"timestamp is"+timestamp+"nonce is :"+nonce);
        if (weixinSignUtil.checkSignature(signature, timestamp, nonce)){
            System.out.println("-----------验证微信服务号结束------------");
            return echostr;
        }else {

            // 此处可以实现其他逻辑
            logger.warn("不是微信服务器发过来的请求，请小心！");
            return null;
        }
    }

    @PostMapping
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = CoreService.processRequest(request);

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();

    }
}


