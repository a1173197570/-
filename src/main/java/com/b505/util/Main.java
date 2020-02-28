package com.b505.util;

import com.b505.code.entity.SNSUserInfo;
import com.b505.pojo.AccessToken;
import com.b505.pojo.Template;
import com.b505.pojo.TemplateParam;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [] args){

        System.out.println("  Ticket是："+AdvancedUtil.getJSApiTicket());


/*
        Template tem=new Template();
        tem.setTemplateId("GnpJCY5J7awYlTBOrHvCGzClENiL7jmBDn_wIHVosRk");
        tem.setTopColor("#00DD00");
        tem.setToUser("oMmYSv_6ab942PjuQ4y-hEN-cIPI");
        tem.setUrl("");

        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("first","您好，您有一条领取的图书信息。 ","#FF3333"));
        paras.add(new TemplateParam("keyword1","百科大全","#0044BB"));
        paras.add(new TemplateParam("keyword2","宋奇豪","#0044BB"));
        paras.add(new TemplateParam("keyword3","2020-2-28 20:07","#0044BB"));
        paras.add(new TemplateParam("keyword4","3天","#0044BB"));
        paras.add(new TemplateParam("Remark","请您及时去书架扫码借书，并根据借书时间按时归还","#AAAAAA"));

        tem.setTemplateParamList(paras);

        AccessToken accessToken = JsapiTicketUnit.getAccessToken("wx6dab4029668e1ee4", "e68f6e030d57df0413d7749ccca1e418");

        System.out.println(accessToken.getToken());

        int a=AdvancedUtil.sendTemplateMsg(accessToken.getToken(),tem);

        System.out.println(a);
*/



/*        AccessToken accessToken= JsapiTicketUnit.getAccessToken("wx6dab4029668e1ee4","e68f6e030d57df0413d7749ccca1e418");

        System.out.println(accessToken.getToken());*/

    }

}
