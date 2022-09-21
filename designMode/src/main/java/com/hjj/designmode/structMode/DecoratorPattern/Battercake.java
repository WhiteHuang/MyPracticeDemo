package com.hjj.designmode.structMode.DecoratorPattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：实现类
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
