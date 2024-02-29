package xyz.linyh.alipaytest.sandBox.common.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.linyh.alipaytest.sandBox.common.config.AlipayConfig;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
@Slf4j
public class AlipaySaoImpl {

    // 实例化客户端
    AlipayClient alipayClient;

    public AlipaySaoImpl() {
        // 实例化客户端
        alipayClient = new DefaultAlipayClient(
                AlipayConfig.ALIPAY_URL,
                AlipayConfig.APP_ID,
                getPrivateKey(),
                AlipayConfig.FORMAT,
                AlipayConfig.CHARSET,
                AlipayConfig.ALIPAY_PUBLIC_KEY,
                AlipayConfig.SIGN_TYPE);
    }

    private String getPrivateKey() {
        String privateKey = "";
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\alipay\\sandbox\\privateKey.txt"))) {
            privateKey = br.readLine();

        } catch (Exception e) {
            System.out.println("获取privateKey出现错误了");

        }

        return privateKey;
    }

}
