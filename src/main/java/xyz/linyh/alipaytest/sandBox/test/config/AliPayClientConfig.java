package xyz.linyh.alipaytest.sandBox.test.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;

@Configuration
public class AliPayClientConfig {


    @Bean
    public AlipayClient myAliPayClient(){
        return new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, getPrivateKey(), "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
    }

    private String getPrivateKey() {
        String privateKey = "";
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\alipay\\sandbox\\customDefinitionPrivateKey.txt"))) {
            privateKey = br.readLine();

        } catch (Exception e) {
            System.out.println("获取privateKey出现错误了");

        }

        return privateKey;
    }
}
