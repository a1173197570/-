package com.b505.service;
import com.b505.message.req.TextMessage;
import com.b505.message.res.Article;
import com.b505.message.res.NewsMessage;
import com.b505.util.MessageUtil;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther meng
 * @Date:2020/2/11
 * @Description:com.example.demo.service
 * @version:1.0
 */
public class CoreService {
    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return
     */
    public static String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            //默认回复信息
            textMessage.setContent("谢谢您关注我的微信公众号");
            respMessage = MessageUtil.textMessageToXml(textMessage);


            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

                //针对用户发送过来的图文消息进行相关的相应
                //接受用户发送过来的文本消息
                String content = requestMap.get("Content");

                //创建图文消息
                NewsMessage newsMessage = new NewsMessage();
                newsMessage.setToUserName(fromUserName);
                newsMessage.setFromUserName(toUserName);
                newsMessage.setCreateTime(new Date().getTime());
                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                newsMessage.setFuncFlag(0);

                List<Article> articleList = new ArrayList<Article>();

                // 单图文消息
                if ("1".equals(content)) {
                    Article article = new Article();
                    article.setTitle("微信公众帐号开发");
                    article.setDescription("B505科研是微信公众账号开发学习");
                    article.setPicUrl("http://39.105.65.69/img/2.png");
                    article.setUrl("http://39.105.65.69/text");
                    articleList.add(article);
                    // 设置图文消息个数
                    newsMessage.setArticleCount(articleList.size());
                    // 设置图文消息包含的图文集合
                    newsMessage.setArticles(articleList);
                    // 将图文消息对象转换成xml字符串
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);

                    return respMessage;
                }

                // 多图文消息
                else if ("3".equals(content)) {
                    Article article1 = new Article();
                    article1.setPicUrl("http://hyxw.work/img/108.jpg");
                    article1.setUrl("");

                    Article article2 = new Article();
                    article2.setTitle("学会章程");
                    article2.setDescription("");
                    article2.setPicUrl("http://hyxw.work/img/constitution.png");
                    article2.setUrl("http://hyxw.work/constitution");


                    Article article4 = new Article();
                    article4.setTitle("分会介绍");
                    article4.setDescription("");
                    article4.setPicUrl("http://hyxw.work/img/location.png");
                    article4.setUrl("http://hyxw.work/location");

                    Article article5 = new Article();
                    article5.setTitle("组织机构");
                    article5.setDescription("");
                    article5.setPicUrl("http://hyxw.work/img/organization.png");
                    article5.setUrl("http://hyxw.work/organization");

                    Article article6 = new Article();
                    article6.setTitle("服务体系");
                    article6.setDescription("");
                    article6.setPicUrl("http://hyxw.work/img/service.png");
                    article6.setUrl("http://hyxw.work/service");


                    articleList.add(article1);
                    articleList.add(article2);
                    articleList.add(article4);
                    articleList.add(article5);
                    articleList.add(article6);


                    newsMessage.setArticleCount(articleList.size());
                    newsMessage.setArticles(articleList);
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);

                    return respMessage;
                }
                // 多图文消息---首条消息不含图

                return respMessage;

            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {


                // 事件类型

                // 事件KEY值，与创建自定义菜单时指定的KEY值对应
                String eventKey = requestMap.get("EventKey");


                //创建图文消息
                NewsMessage newsMessage = new NewsMessage();
                newsMessage.setToUserName(fromUserName);
                newsMessage.setFromUserName(toUserName);
                newsMessage.setCreateTime(new Date().getTime());
                newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                newsMessage.setFuncFlag(0);

                List<Article> articleList = new ArrayList<Article>();

                if (eventKey.equals("21")) {
                    Article article1 = new Article();
                    article1.setTitle("微信公众帐号开发");
                    article1.setDescription("xxx");
                    // 将图片置为空
                    article1.setPicUrl("");
                    article1.setUrl("http://39.105.65.69/text");

                    Article article2 = new Article();
                    article2.setTitle("第4篇\n微信公众账号开发");
                    article2.setDescription("");
                    article2.setPicUrl("https://s2.ax1x.com/2020/02/19/3Ez9hQ.png");
                    article2.setUrl("http://39.105.65.69/text");

                    Article article3 = new Article();
                    article3.setTitle("第5篇\n微信公众账号开发");
                    article3.setDescription("");
                    article3.setPicUrl("https://s2.ax1x.com/2020/02/19/3Ez9hQ.png");
                    article3.setUrl("http://39.105.65.69/text");

                    Article article4 = new Article();
                    article4.setTitle("第6篇\n微信公众账号开发");
                    article4.setDescription("");
                    article4.setPicUrl("https://s2.ax1x.com/2020/02/19/3Ez9hQ.png");
                    article4.setUrl("http://39.105.65.69/text");

                    articleList.add(article1);
                    articleList.add(article2);
                    articleList.add(article3);
                    articleList.add(article4);
                    newsMessage.setArticleCount(articleList.size());
                    newsMessage.setArticles(articleList);
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);

                    return respMessage;
                }
                else if (eventKey.equals("22")){
                    // https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=147881724,2614903222&fm=26&gp=0.jpg
                    Article article5 = new Article();
                    article5.setTitle("新品上市");
                    article5.setDescription("");
                    article5.setPicUrl("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=147881724,2614903222&fm=26&gp=0.jpg");
                    article5.setUrl("https://www.baidu.com");

                    Article article6 = new Article();
                    article6.setTitle("第一条");
                    article6.setDescription("");
                    article6.setPicUrl("");
                    article6.setUrl("https://171.16km.cn");

                    articleList.add(article5);
                    articleList.add(article6);
                    newsMessage.setArticleCount(articleList.size());
                    newsMessage.setArticles(articleList);
                    respMessage = MessageUtil.newsMessageToXml(newsMessage);

                    return respMessage;

                }

                return respMessage;
            }

            String eventType = requestMap.get("Event");
            // 订阅
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                respContent = "谢谢您的关注！";
            }
            // 取消订阅
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
            }
            // 自定义菜单点击事件
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                // TODO 自定义菜单权没有开放，暂不处理该类消息
            }

            textMessage.setContent(respContent);
            respMessage = MessageUtil.textMessageToXml(textMessage);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return respMessage;
    }
}

