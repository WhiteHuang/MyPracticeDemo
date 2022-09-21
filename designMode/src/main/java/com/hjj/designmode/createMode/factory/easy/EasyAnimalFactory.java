package com.hjj.designmode.createMode.factory.easy;

import com.hjj.designmode.createMode.factory.product.Animal;
import com.hjj.designmode.createMode.factory.product.Cat;
import com.hjj.designmode.createMode.factory.product.Dog;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述： 简单工厂
 */
public class EasyAnimalFactory  {

    private static Animal createDog(){
        return new Dog();
    }

    private static Animal createCat(){
        return new Cat();
    }

    public static Animal createAnimal(String type) {
        if("dog".equals(type)){
            return createDog();
        }else if("cat".equals(type)){
            return createCat();
        }

            return null;
    }
}
