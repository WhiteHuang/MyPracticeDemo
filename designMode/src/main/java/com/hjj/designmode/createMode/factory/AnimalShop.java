package com.hjj.designmode.createMode.factory;

import com.hjj.designmode.createMode.factory.abstract1.FemaleAnimalFactory;
import com.hjj.designmode.createMode.factory.abstract1.MaleAnimalFactory;
import com.hjj.designmode.createMode.factory.abstractProduct.AbstractAnimal;
import com.hjj.designmode.createMode.factory.easy.EasyAnimalFactory;
import com.hjj.designmode.createMode.factory.normal.CatFactory;
import com.hjj.designmode.createMode.factory.normal.DogFactory;
import com.hjj.designmode.createMode.factory.product.Animal;

/**
 * 创建时间：2022/9/19
 * 作者：
 * 功能描述：
 */
public class AnimalShop {
    public static void main(String[] args) {
        Animal cat = getAnimal(new CatFactory());
        Animal dog = getAnimal(new DogFactory());
        cat.eat();
        dog.eat();


        Animal easyCat = EasyAnimalFactory.createAnimal("cat");
        Animal easyDog = EasyAnimalFactory.createAnimal("dog");
        easyCat.eat();
        easyDog.eat();

        AbstractAnimal femaleDog=new FemaleAnimalFactory().createDog();
        AbstractAnimal femaleCat=new FemaleAnimalFactory().createCat();
        AbstractAnimal maleCat=new MaleAnimalFactory().createCat();
        AbstractAnimal maleDog=new MaleAnimalFactory().createDog();


    }

    private static Animal getAnimal(AnimalFactory factory) {
        Animal animal = factory.createAnimal();
        return animal;
    }
}
