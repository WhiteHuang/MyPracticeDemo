package com.hjj.designmode.createMode.prototype;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

/**
 * 创建时间：2022/9/20
 * 作者：
 * 功能描述：原型模式。支持类的克隆，可以快速创建类，
 * 浅拷贝：浅拷贝类中的引用对象不会进行数据拷贝
 * 深拷贝：引用对象需要调用自身的clone方法进行深度拷贝
 */
public class Message implements Cloneable {

    private String name;
    private ExpenseDetail detail;

    public Message(String name,String type,double money){
        this.name=name;
        this.detail=new ExpenseDetail(type, money);
    }

    public void setMessage(String name, String type,double money) {
        this.name = name;
        this.detail.setType(type);
        this.detail.setMoney(money);
    }

    @NonNull
    @NotNull
    @Override
    protected Message clone()  {
        Message msg=null;
        try {
            msg= (Message) super.clone();
            msg.detail=detail.clone();//引用对象无法进行深拷贝所以需要自行调用clone方法
        }catch (CloneNotSupportedException e){

        }
        return msg;
    }
}
