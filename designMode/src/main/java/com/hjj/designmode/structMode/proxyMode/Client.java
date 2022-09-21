package com.hjj.designmode.structMode.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class Client {
    public static void main(String[] args) {
        //静态代理
        IRentHouse rentHouse = new RentHouse();
        IRentHouse proxy=new IntermediaryProxy(rentHouse);
        proxy.rentHouse();

        //动态代理
        IRentHouse proxy1 = JdkProxyFactory.getProxy(new RentHouse());
        proxy1.rentHouse();
    }
}
