package xyz.linyh.alipaytest.sandBox.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.linyh.alipaytest.sandBox.common.service.PayService;

@RestController
@RequestMapping("/order")
public class PayController {

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public String createOrder() {
        try {
            return payService.createOrder();
        } catch (Exception e) {
            System.out.println("controller 出现错误了");
        }
       return "error";

    }
}
