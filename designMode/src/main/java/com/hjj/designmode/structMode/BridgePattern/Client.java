package com.hjj.designmode.structMode.BridgePattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：桥接模式
 * 1、抽象化(Abstraction)角色：抽象化给出的定义，并保存一个对实现化对象的引用 {@Coffee}。
 * 2、修正抽象化(RefinedAbstraction)角色：扩展抽象化角色，改变和修正父类对抽象化的定义{@RefinedCoffee}。
 * 3、实现化(Implementor)角色：这个角色给出实现化角色的接口，但不给出具体的实现。
 * 必须指出的是，这个接口不一定和抽象化角色的接口定义相同，实际上，这两个接口可以非常不一样。
 * 实现化角色应当只给出底层操作，而抽象化角色应当只给出基于底层操作的更高一层的操作。
 * 4、具体实现化(ConcreteImplementor)角色：这个角色给出实现化角色接口的具体实现。
 */
public class Client {
    public static void main(String[] args) {
        RefinedCoffee coffee=new LargeCoffee(new Sugar());
        coffee.orderCoffee(3);
        coffee.checkQuality();
    }
}
