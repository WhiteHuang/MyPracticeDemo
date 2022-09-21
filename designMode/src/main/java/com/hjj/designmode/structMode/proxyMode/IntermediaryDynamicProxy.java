package com.hjj.designmode.structMode.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：动态代理类
 * 通过实现InvovationHandler 实现invoke方法进行拦截动态代理
 */
public class IntermediaryDynamicProxy implements InvocationHandler {


    private Object obj;

    public IntermediaryDynamicProxy(Object object){
        obj = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("交中介费");
        Object result = method.invoke(this.obj, args);
        System.out.println("中介负责维修管理");
        return result;
    }
}
