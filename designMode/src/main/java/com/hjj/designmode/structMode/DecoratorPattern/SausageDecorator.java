package com.hjj.designmode.structMode.DecoratorPattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：抽象装饰实现类
 */
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一个香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 3;
    }

    public void egg() {
        System.out.println("增加了一个香肠");
    }
}
