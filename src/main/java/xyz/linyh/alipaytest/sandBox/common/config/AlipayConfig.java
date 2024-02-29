package xyz.linyh.alipaytest.sandBox.common.config;

public class AlipayConfig {

        /**
         * 签约的支付宝账号对应的支付宝唯一用户号，以2088开头的16位纯数字组成
         */
        public static final String PID = "2088721025873739";

        /**
         * 正式环境请求地址
         */
        public static String ALIPAY_URL = "https://openapi.alipay.com/gateway.do";

        /**
         * 支付宝分配给开发者的应用ID
         *
         */
        public static String APP_ID = "9021000133635987";

        /**
         * 仅支持JSON
         */
        public static String FORMAT = "JSON";

        /**
         * 请求使用的编码格式
         */
        public static String CHARSET = "utf-8";

        /**
         * 商户生成签名字符串所使用的签名算法类型
         */
        public static String SIGN_TYPE = "RSA2";

        /**
         * 支付宝公钥
         */
        public static String ALIPAY_PUBLIC_KEY ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw62SLpc1e4QmdV3GthkfElT9jcF8sgyWaRQYfLRZKj2XcCZkYS+hKSuDj1aTAsgUFpd3plWtFTbGqvcl8wYmgpVKzMQBQ5b0ptRLXuOR0zcPxtJvC6h1tmp12N2bkA4gzy5UI5ois4eX4DGTjMq7G9AIk8me1QYPic/ivcFzuW77cWdWVdrLCvn8nk2KRxr+BdbIlk+m2k5W4wDBeogrhRZlT0cJZ21p5dz4EPqoaDViEiO9oiO/w2bHN6Jz2VI1dOjGoTzSPcJASZ+Gpi+9TCHkKuflY7pInCVfLAMEBujnm7N7Ib/kENt1ytgnljcd6BFIpln3ZEAr5OGZIRW1ZwIDAQAB";
        /**
         * 商户私钥(从文件中获取)
         */
        public static String PRIVATE_KEY ="xx";

        /**
         * 回调地址
         */
        public static String CALLBACK_URL = "xx";

        /**
         * web支付跳转地址
         */
        public static String WEB_RETURN_URL = "xx";

}