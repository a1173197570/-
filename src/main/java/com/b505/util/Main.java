package com.b505.util;

import com.b505.pojo.AccessToken;

public class Main {

    public static void main(String [] args){

        AccessToken accessToken= JsapiTicketUnit.getAccessToken("wx6dab4029668e1ee4","e68f6e030d57df0413d7749ccca1e418");

        System.out.println(accessToken.getToken());

    }

}
