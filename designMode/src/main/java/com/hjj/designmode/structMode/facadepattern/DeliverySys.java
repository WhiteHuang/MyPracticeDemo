package com.hjj.designmode.structMode.facadepattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class DeliverySys {
    public int getDeliveryTime(){
        System.out.println("获取配送耗时");
        return 30*60;//30分钟
    }
}
