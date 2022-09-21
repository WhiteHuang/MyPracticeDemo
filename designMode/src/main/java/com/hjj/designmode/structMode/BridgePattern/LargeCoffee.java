package com.hjj.designmode.structMode.BridgePattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class LargeCoffee extends RefinedCoffee {
    public LargeCoffee(ICoffeeAdditives coffeeAdditives) {
        super(coffeeAdditives);
    }

    @Override
    public void orderCoffee(int count) {
        System.out.println(String.format("大杯咖啡%d杯",count));
    }
}
