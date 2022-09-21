package com.hjj.designmode.structMode.adapterPattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class Client {
    public static void main(String[] args) {
        OldLog log=new LogAdapter(new NewlogImpl());
        log.log();
    }
}
