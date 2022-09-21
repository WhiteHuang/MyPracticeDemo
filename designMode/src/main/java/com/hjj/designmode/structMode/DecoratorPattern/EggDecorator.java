package com.hjj.designmode.structMode.DecoratorPattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：抽象装饰实现类
 */
public class EggDecorator extends AbstractDecorator {
    public EggDecorator(ABattercake aBattercake) {
        super(aBattercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }

    public void egg() {
        System.out.println("增加了一个鸡蛋");
    }
}
