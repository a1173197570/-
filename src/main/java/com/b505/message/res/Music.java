package com.b505.message.res;

public class Music {

    // 音乐名称
    private String Title;
    // 音乐描述
    private String MusicUrl;
    //高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String getTitle() { return Title; }

    public void getTitle(String title) { Title = title; }

}
