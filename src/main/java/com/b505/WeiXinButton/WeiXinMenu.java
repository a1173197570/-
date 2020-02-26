package com.b505.WeiXinButton;

import com.b505.pojo.*;
import com.b505.util.JsapiTicketUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by feire on 2020/2/17.
 */
public class WeiXinMenu {
    private static Logger log = LoggerFactory.getLogger(WeiXinMenu.class);


    public static void main(String[] args){

        // 调用接口获取access_token
        AccessToken accesstoken= JsapiTicketUnit.getAccessToken("wx6dab4029668e1ee4","e68f6e030d57df0413d7749ccca1e418");

        System.out.println( 1 );
        if (null != accesstoken) {
            // 调用接口创建菜单
            int result = JsapiTicketUnit.createMenu( getMenu(),accesstoken.getToken() );

            // 判断菜单创建结果
            if (0 == result) {
                System.out.println( "111" );
                log.info( "菜单建立成功" );
            }else {
                log.info( "菜单建立失败" + result );
            }
        }
    }


    public static Menu getMenu() {

        CommonButton btn11 = new CommonButton();
        btn11.setName("徐");
        btn11.setType("click");
        btn11.setKey("11");

        CommonButton btn12=new CommonButton();
        btn12.setName("坦");
        btn12.setType("click");
        btn12.setKey("12");

        CommonButton btn13=new CommonButton();
        btn13.setName("彪");
        btn13.setType("view");
        btn13.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6dab4029668e1ee4&redirect_uri=http://1fbf9d7c.ngrok.io/text1&response_type=code&scope=snsapi_userinfo&state=STATE&connect_redirect=1#wechat_redirect");

        ComplexButton mainBtn1=new ComplexButton();
        mainBtn1.setName("个人主页");
        mainBtn1.setSub_button(new CommonButton[]{btn11,btn12,btn13});

        CommonButton btn21=new CommonButton();
        btn21.setName("中一");
        btn21.setType("click");
        btn21.setKey("21");

        CommonButton btn22=new CommonButton();
        btn22.setName("中二");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn23=new CommonButton();
        btn23.setName("中三");
        btn23.setType("click");
        btn23.setKey("23");

        ComplexButton mainBtn2=new ComplexButton();
        mainBtn2.setName("中间菜单");
        mainBtn2.setSub_button(new CommonButton[]{btn21,btn22,btn23});

        CommonButton btn31=new CommonButton();
        btn31.setName("扫一扫");
        btn31.setType("scancode_push");
        btn31.setKey("31");


        CommonButton btn32=new CommonButton();
        btn32.setName("右二");
        btn32.setType("click");
        btn32.setKey("32");

        CommonButton btn33=new CommonButton();
        btn33.setName("右三");
        btn33.setType("click");
        btn33.setKey("33");

        ComplexButton mainBtn3=new ComplexButton();
        mainBtn3.setName("右边菜单");
        mainBtn3.setSub_button(new CommonButton[]{btn31,btn32,btn33});

        Menu menu = new Menu();
        menu.setButton(new Button[] {mainBtn1,mainBtn2,mainBtn3 });

        return menu;
    }

}
