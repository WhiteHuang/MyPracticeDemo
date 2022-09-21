package com.hjj.designmode.structMode.facadepattern;

import java.math.BigDecimal;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class PaymentSys {
    private OrderSys orderSys;
    public PaymentSys(OrderSys orderSys) {
        this.orderSys = orderSys;
    }
    public BigDecimal getOrderAccount(String orderNum){
        System.out.println(String.format("获取%s订单支付金额",orderNum));
        return BigDecimal.valueOf(500);
    }
}
