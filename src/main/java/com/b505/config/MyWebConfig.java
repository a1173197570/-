package com.b505.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {


    /**
     * /**的意思是所有文件，包括文件夹中的子文件
     * /*是所有文件，不包含子文件
     * /是web项目的根目录
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //两个*表示以/uploadFiles开始的任意层级的路径都可以访问得到图片，如<img src="../uploadFiles/img/1.png">
        //一个*表示只可以访问assets目录下的图片文件
        //addResourceHandler指的是访问路径，addResourceLocations指的是文件放置目录
		/*registry.addResourceHandler("/chargeFile/**").addResourceLocations("classpath:/chargeFile");*/

        registry.addResourceHandler("/img/**").addResourceLocations( ResourceUtils.CLASSPATH_URL_PREFIX+"/static/img/");
    }

}