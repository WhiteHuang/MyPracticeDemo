package com.hjj.designmode.createMode.factory;

import com.hjj.designmode.createMode.factory.product.Animal;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述：工厂模式接口
 * 增加产品时，产品线不变，新增产品工厂
 */
public interface AnimalFactory {
    Animal createAnimal();
}
