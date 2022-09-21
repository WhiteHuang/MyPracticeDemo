package com.hjj.designmode.structMode.proxyMode;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class RentHouse implements IRentHouse {
    @Override
    public void rentHouse() {
        System.out.println("租了一间房子。。。");
    }
}
