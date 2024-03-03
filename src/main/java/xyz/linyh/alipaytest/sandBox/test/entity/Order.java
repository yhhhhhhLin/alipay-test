package xyz.linyh.alipaytest.sandBox.test.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    String orderId;

    String goodsName;

    String goodsPrice;

    String goodsCount;

    String goodsTotal;

    String goodsDesc;

    Date createTime;
}
