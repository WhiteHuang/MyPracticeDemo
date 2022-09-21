package com.hjj.designmode.structMode.proxyMode;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：静态代理
 *
 */
public class IntermediaryProxy implements IRentHouse{
    private IRentHouse rentHouse;

    public IntermediaryProxy(IRentHouse rentHouse){
        this.rentHouse=rentHouse;
    }

    @Override
    public void rentHouse() {
        System.out.println("交中介费");
        rentHouse.rentHouse();
        System.out.println("中介负责维修管理");
    }
}
