package xyz.linyh.alipaytest.sandBox.test.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.linyh.alipaytest.sandBox.test.config.AlipayConfig;
import xyz.linyh.alipaytest.sandBox.test.entity.Order;
import xyz.linyh.alipaytest.sandBox.test.service.PayService2;

import java.util.Date;
import java.util.Map;

@Controller
@ResponseBody
@RestController
@RequestMapping("/test")
public class PayController2 {

    @Autowired
    private PayService2 payService2;


    @GetMapping("/order/pay")
    public String createPay(@RequestParam String orderId) {
        String result = null;

        try {
            result = payService2.createPay("1", orderId);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @GetMapping("/order/create")
    public Order createOrder(String goodsId) {
        Order order = getGoodsInfo(goodsId);

        Snowflake snowflake = IdUtil.getSnowflake();
        String orderId = snowflake.nextIdStr();

        order.setOrderId(orderId);
        return order;
    }

    private Order getGoodsInfo(String goodsId) {
        Order order = new Order();

        switch (goodsId) {
            case "1":
                order.setGoodsName("小米手机");
                order.setGoodsPrice("9.9");
                order.setGoodsCount("1");
                order.setGoodsTotal("1");
                order.setGoodsDesc("小米手机描述");
                order.setCreateTime(new Date());
                break;
            case "2":
                order.setGoodsName("华为手机");
                order.setGoodsPrice("19.9");
                order.setGoodsCount("1");
                order.setGoodsTotal("1");
                order.setGoodsDesc("华为手机描述");
                order.setCreateTime(new Date());
                break;
            case "3":
                order.setGoodsName("苹果手机");
                order.setGoodsPrice("29.9");
                order.setGoodsCount("1");
                order.setGoodsTotal("1");
                order.setGoodsDesc("苹果手机描述");
                order.setCreateTime(new Date());
                break;
            case "4":
                order.setGoodsName("华为笔记本");
                order.setGoodsPrice("39.9");
                order.setGoodsCount("1");
                order.setGoodsTotal("1");
                order.setGoodsDesc("华为笔记本描述");
                order.setCreateTime(new Date());
                break;
        }

        return order;
    }

    @PostMapping("/order/url/notify")
    public void notifyUrl(@RequestParam Map<String,String> params) throws AlipayApiException {
//        1. 进行参数校验判断是否合法
        boolean checkResult = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        if(checkResult){
            System.out.println("接收到notify信息，验签成功,参数为:"+params);
        }else{
            System.out.println("接收到notify信息，验签失败,参数为:"+params);
        }
    }

    @GetMapping("/order/url/return")
    public void returnUrl(String out_trade_no){
        System.out.println("接收到return返回的，订单号为："+out_trade_no);
    }
}
