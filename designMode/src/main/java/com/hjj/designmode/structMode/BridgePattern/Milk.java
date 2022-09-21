package com.hjj.designmode.structMode.BridgePattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class Milk implements ICoffeeAdditives {
    @Override
    public void addSomething() {
        System.out.println("加奶");
    }
}
