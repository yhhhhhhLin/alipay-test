package xyz.linyh.alipaytest.sandBox.test.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.linyh.alipaytest.sandBox.test.config.AlipayConfig;

@Service
public class PayService2 {

    @Autowired
    private AlipayClient myAliPayClient;

    public String createPay(String userId,String goodsId) throws Exception {

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
//        TODO 配置
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String("9920182124".getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount = new String("9.9".getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String("测试订单2".getBytes("ISO-8859-1"),"UTF-8");
        //商品描述，可空
        String body = new String("测试商品描述2".getBytes("ISO-8859-1"),"UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        return myAliPayClient.pageExecute(alipayRequest).getBody();

    }
}
