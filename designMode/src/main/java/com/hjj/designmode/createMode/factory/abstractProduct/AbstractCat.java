package com.hjj.designmode.createMode.factory.abstractProduct;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述：
 */
public abstract class AbstractCat extends AbstractAnimal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
