package xyz.linyh.alipaytest.sandBox.test.controller;

import java.util.Date;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alipay.api.AlipayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.linyh.alipaytest.sandBox.test.entity.Order;
import xyz.linyh.alipaytest.sandBox.test.service.PayService2;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
@RestController
@RequestMapping("/test")
public class PayController2 {

    @Autowired
    private PayService2 payService2;


    @GetMapping("/order/pay")
    public String createPay(@RequestParam String goodsId) {


        String result = null;

        try {
            result = payService2.createPay("1", goodsId);
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
}
