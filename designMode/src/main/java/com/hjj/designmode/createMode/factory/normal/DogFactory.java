package com.hjj.designmode.createMode.factory.normal;

import com.hjj.designmode.createMode.factory.product.Animal;
import com.hjj.designmode.createMode.factory.AnimalFactory;
import com.hjj.designmode.createMode.factory.product.Dog;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述：
 */
public class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
