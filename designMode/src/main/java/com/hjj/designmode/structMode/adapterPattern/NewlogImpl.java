package com.hjj.designmode.structMode.adapterPattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class NewlogImpl implements NewLog {
    @Override
    public void d(int priority, String message, Object... obj) {
        System.out.println(String.format("牛逼logger记录:%s",message));
    }
}
