package com.hjj.designmode.structMode.proxyMode;

import java.lang.reflect.Proxy;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class JdkProxyFactory {
    public  static <T> T getProxy(T obj){
        return (T)Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                new Class[]{obj.getClass()},new IntermediaryDynamicProxy(obj));
    }
}
