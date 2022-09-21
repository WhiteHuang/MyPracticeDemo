package com.hjj.designmode.createMode.factory.abstract1;

import com.hjj.designmode.createMode.factory.AbstractAnimalFactory;
import com.hjj.designmode.createMode.factory.abstractProduct.AbstractAnimal;
import com.hjj.designmode.createMode.factory.abstractProduct.FemaleCat;
import com.hjj.designmode.createMode.factory.abstractProduct.FemaleDog;
import com.hjj.designmode.createMode.factory.product.Animal;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述：
 */
public class FemaleAnimalFactory implements AbstractAnimalFactory {
    @Override
    public AbstractAnimal createDog() {
        return new FemaleDog();
    }

    @Override
    public AbstractAnimal createCat() {
        return new FemaleCat();
    }
}
