package com.hjj.designmode.structMode.BridgePattern;

import java.util.Random;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public abstract class RefinedCoffee extends Coffee {
    public RefinedCoffee(ICoffeeAdditives coffeeAdditives) {
        super(coffeeAdditives);
    }

    public void checkQuality(){
        Random ran=new Random();
        System.out.println(String.format("%s 添加%s",additives.getClass().getSimpleName(),ran.nextBoolean()?"太多":"正常"));
    }
}
