package xyz.linyh.alipaytest.sandBox.easy;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.factory.Factory.Payment;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import xyz.linyh.alipaytest.sandBox.easy.properties.AliPayProperties;

import java.io.BufferedReader;
import java.io.FileReader;



public class Main {
    public static void main(String[] args) throws Exception {
        // 1. 设置参数（全局只需设置一次）
        AliPayProperties properties = initProperties();
        Factory.setOptions(getOptions(properties));
        try {
            // 2. 发起API调用（以创建当面付收款二维码为例）
            AlipayTradePrecreateResponse response = Payment.FaceToFace()
                    .preCreate("Apple iPhone11 128G", "2234567890", "5799.00");
            // 3. 处理响应或异常
            if (ResponseChecker.success(response)) {
                System.out.println("调用成功");
            } else {
                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
            }
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static Config getOptions(AliPayProperties properties) {
        Config config = new Config();
        config.protocol = properties.getProtocol();
//        config.protocol = "https";
        config.gatewayHost = properties.getGatewayHost();
//        config.gatewayHost = "openapi.alipay.com";
        config.signType = properties.getSignType();
//        config.signType = "RSA2";
        config.appId = properties.getAppId();
//        config.appId = "9021000133635987";
        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = properties.getAppPrivateKey();
//        config.merchantPrivateKey = "<-- 请填写您的应用私钥，例如：MIIEvQIBADANB ... ... -->";

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
        //注：如果采用非证书模式，则无需赋值下面的三个证书路径
        config.merchantCertPath = properties.getMerchantCertPath();
//        config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
        config.alipayCertPath = properties.getAlipayCertPath();
//        config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
        config.alipayRootCertPath = properties.getAlipayRootCertPath();
//        config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

         config.alipayPublicKey = properties.getAlipayPublicKey();
        // config.alipayPublicKey = "<-- 请填写您的支付宝公钥，例如：MIIBIjANBg... -->";
        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = properties.getNotifyUrl();
//        config.notifyUrl = "<-- 请填写您的支付类接口异步通知接收服务地址，例如：https://www.test.com/callback -->";
        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
        config.encryptKey = "<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->";
        return config;
    }

    private static String getPrivateKey() {
        String privateKey = "";
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\alipay\\sandbox\\privateKey.txt"))) {
            privateKey = br.readLine();

        }catch (Exception e) {
            System.out.println("获取privateKey出现错误了");

        }
        System.out.println("privateKey为"+privateKey);

        return privateKey;
    }

    private static AliPayProperties initProperties(){
        AliPayProperties properties = new AliPayProperties();
        properties.setAppId("9021000133635987");
        properties.setAppPrivateKey(getPrivateKey());
        properties.setAlipayPublicKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw62SLpc1e4QmdV3GthkfElT9jcF8sgyWaRQYfLRZKj2XcCZkYS+hKSuDj1aTAsgUFpd3plWtFTbGqvcl8wYmgpVKzMQBQ5b0ptRLXuOR0zcPxtJvC6h1tmp12N2bkA4gzy5UI5ois4eX4DGTjMq7G9AIk8me1QYPic/ivcFzuW77cWdWVdrLCvn8nk2KRxr+BdbIlk+m2k5W4wDBeogrhRZlT0cJZ21p5dz4EPqoaDViEiO9oiO/w2bHN6Jz2VI1dOjGoTzSPcJASZ+Gpi+9TCHkKuflY7pInCVfLAMEBujnm7N7Ib/kENt1ytgnljcd6BFIpln3ZEAr5OGZIRW1ZwIDAQAB");
        properties.setProtocol("https");
        properties.setGatewayHost("openapi.alipay.com");
        properties.setSignType("RSA2");

//        有证书认证的时候还需要用到
        properties.setMerchantCertPath(null);
        properties.setAlipayCertPath(null);
        properties.setAlipayRootCertPath(null);

        properties.setNotifyUrl("https://www.test.com/callback");


        return properties;

    }
}