package com.b505.util;

import com.b505.pojo.AccessToken;
import com.b505.pojo.Menu;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;


public class JsapiTicketUnit {

    private static Logger logger = LoggerFactory.getLogger(JsapiTicketUnit.class);

    //获取access_token的接口地址（GET） 限定2000次
    public final static String access_token = " https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //菜单创建（POST）100次/天
    public final static String menu_create_url=" https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";


    /**
     * 创建菜单
     */
    public static int createMenu(Menu menu,String accessToken){

        //拼装创建菜单的url
        String url=menu_create_url.replace("ACCESS_TOKEN",accessToken);

        //将菜单对象转换成json字符串
        String jsonMenu=JSONObject.fromObject(menu).toString();

        //调用接口创建菜单
        JSONObject jsonObject=httpRequest(url,"POST",jsonMenu);

        int result=0;

        if(null!=jsonObject){

            if(jsonObject.getInt("errcode")!=0){

                result=jsonObject.getInt("errcode");

                System.out.println("我是错误码"+result+"错误信息"+jsonObject.getString("errmsg"));

                logger.error("获取菜单失败",jsonObject.getInt("errcode"),jsonObject.getString("errmsg"));
            } }

        return result;

    }




    /**
     * 获取access_token
     *
     * @param appid     凭证
     * @param appsecret 密钥
     */
    public static AccessToken getAccessToken(String appid, String appsecret) {

        AccessToken accessToken = null;

        String requestUrl = access_token.replace("APPID", appid).replace("APPSECRET", appsecret);

        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

        //如果请求成功了
        if(null != jsonObject){

            try {
                accessToken=new AccessToken();
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
                accessToken.setToken(jsonObject.getString("access_token"));
            }catch (JSONException e){

                accessToken=null;
                logger.error("获取token失败",jsonObject.getInt("errcode"),jsonObject.getString("errmsg"));
            }

        }


        return accessToken;
    }


    /**
     * 发起https请求
     *
     * @param requestUrl 请求地址
     * @param requestMethod    请求方式（GET POST）
     * @param outputStr        提交数据
     * @return 获取json对象属性值
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new My509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            logger.error("Weixin server connection timed out.");

        } catch (Exception e) {
            logger.error("https request error:{}", e);
        }
        return jsonObject;
    }





}