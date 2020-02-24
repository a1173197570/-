package com.b505.util;

/**
 * Created by feire on 2020/2/13.
 */

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 证书信任管理器（用于https请求）
 *
 * @author yulin
 * @date 2018-5-4
 */
public class My509TrustManager implements X509TrustManager {


    //检查客户端证书
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    //检查服务器端的证书
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    //返回受到信任的x509数组
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
