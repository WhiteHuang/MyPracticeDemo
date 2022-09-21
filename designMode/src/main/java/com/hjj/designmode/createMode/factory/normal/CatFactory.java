package com.hjj.designmode.createMode.factory.normal;

import com.hjj.designmode.createMode.factory.product.Animal;
import com.hjj.designmode.createMode.factory.AnimalFactory;
import com.hjj.designmode.createMode.factory.product.Cat;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述：工厂模式实现类
 */
public class CatFactory implements AnimalFactory {

    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
