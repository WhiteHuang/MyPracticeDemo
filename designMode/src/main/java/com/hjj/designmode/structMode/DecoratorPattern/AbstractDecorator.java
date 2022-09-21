package com.hjj.designmode.structMode.DecoratorPattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：抽象装饰类
 */
public abstract class AbstractDecorator extends ABattercake{
    private ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    protected abstract void doSomething();

    @Override
    protected String getDesc() {
        return aBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return aBattercake.cost();
    }
}
