package com.hjj.designmode.createMode.builder;

/**
 * 创建时间：2022/9/20
 * 作者：
 * 功能描述：
 */
public class BuilderClient {
    public static void main(String[] args) {
        Computer computer=new Computer.Builder("因特尔","三星")
                .setDisplay("三星24寸")
                .setKeyBoard("罗技")
                .setUsbCount(2)
                .build();
    }
}
