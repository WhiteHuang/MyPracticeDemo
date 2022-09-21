package com.hjj.designmode.createMode.prototype;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

/**
 * 创建时间：2022/9/20
 * 作者：
 * 功能描述：
 */
public class ExpenseDetail implements Cloneable {
    private String type;
    private double money;

    public ExpenseDetail(String type, double money) {
        this.type = type;
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @NonNull
    @NotNull
    @Override
    protected ExpenseDetail clone(){
        ExpenseDetail detail = null;
        try {
            detail = (ExpenseDetail) super.clone();
        } catch (CloneNotSupportedException e) {

        }
        return detail;
    }
}
