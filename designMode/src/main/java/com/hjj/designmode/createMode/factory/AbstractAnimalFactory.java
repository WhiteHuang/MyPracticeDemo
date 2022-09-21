package com.hjj.designmode.createMode.factory;

import com.hjj.designmode.createMode.factory.abstractProduct.AbstractAnimal;
import com.hjj.designmode.createMode.factory.product.Animal;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述：抽象工厂模式接口
 * 增加产品时，工厂数量不变，增加产品线。
 */
public interface AbstractAnimalFactory {
    AbstractAnimal createDog();

    AbstractAnimal createCat();
}
