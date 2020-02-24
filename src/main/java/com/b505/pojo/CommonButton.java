package com.b505.pojo;

/**
 * Created by feire on 2020/2/13.
 */
public class CommonButton extends Button
{
    private String type;
    private String key;
    private String url;
    //media_id类型和view_limited类型必须 调用新增永久素材接口返回的合法media_id
    private String media_id;
    //miniprogram类型必须 小程序的appid（仅认证公众号可配置）
    private String appid ;
    private String pagepath;


    public String getPagepath()
    {
        return pagepath;
    }

    public void setPagepath(String pagepath)
    {
        this.pagepath = pagepath;
    }

    public String getMedia_id()
    {
        return media_id;
    }

    public void setMedia_id(String media_id)
    {
        this.media_id = media_id;
    }

    public String getAppid()
    {
        return appid;
    }

    public void setAppid(String appid)
    {
        this.appid = appid;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}