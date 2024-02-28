package xyz.linyh.alipaytest.sandBox.easy.properties;

import lombok.Data;

@Data
public class AliPayProperties {

    private String appId;

    private String appPrivateKey;

    private String alipayPublicKey;

    private String protocol;

    private String gatewayHost;

    private String signType;

    /**
     * 用户公钥信息路径
     */
    private String merchantCertPath;

    private String alipayCertPath;

    private String alipayRootCertPath;

    private String notifyUrl;
}
