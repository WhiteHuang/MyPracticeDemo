package com.hjj.designmode.structMode.facadepattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述： 外观模式，
 * 对外提供统一调用
 */
public class ReportFacade {
    public void generateReport(){
        OrderSys orderSys = new OrderSys();
        PaymentSys paymentSys = new PaymentSys(orderSys);
        DeliverySys deliverySys = new DeliverySys();

        final String orderNum = orderSys.getOrderNum();
        System.out.println(String.format("\n报表\n--------------------------------------------\n" +
                        "订单号：%s | 金额：%s元 | 配送耗时：%s分钟",
                orderNum,
                paymentSys.getOrderAccount(orderNum).toPlainString(),
                String.valueOf(deliverySys.getDeliveryTime() / 60))
        );
    }
}
