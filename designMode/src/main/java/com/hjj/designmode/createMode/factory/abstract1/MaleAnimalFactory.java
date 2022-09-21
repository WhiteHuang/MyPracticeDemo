package com.hjj.designmode.createMode.factory.abstract1;

import com.hjj.designmode.createMode.factory.AbstractAnimalFactory;
import com.hjj.designmode.createMode.factory.abstractProduct.AbstractAnimal;
import com.hjj.designmode.createMode.factory.abstractProduct.FemaleCat;
import com.hjj.designmode.createMode.factory.abstractProduct.FemaleDog;
import com.hjj.designmode.createMode.factory.abstractProduct.MaleCat;
import com.hjj.designmode.createMode.factory.abstractProduct.MaleDog;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述：
 */
public class MaleAnimalFactory implements AbstractAnimalFactory {
    @Override
    public AbstractAnimal createDog() {
        return new MaleDog();
    }

    @Override
    public AbstractAnimal createCat() {
        return new MaleCat();
    }
}
