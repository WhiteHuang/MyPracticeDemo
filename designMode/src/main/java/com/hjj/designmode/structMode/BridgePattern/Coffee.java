package com.hjj.designmode.structMode.BridgePattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public abstract class Coffee {
    protected ICoffeeAdditives additives;

    public Coffee(ICoffeeAdditives coffeeAdditives) {
        this.additives = coffeeAdditives;
    }

    public abstract void orderCoffee(int count);
}
