package com.hjj.designmode.structMode.adapterPattern;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：适配器模式
 *
 * 通过继承就log的接口，注入新log的实现，在就行为中调用新log
 */
public class LogAdapter implements OldLog {
    NewLog nLog;
    public LogAdapter(NewLog log){
        nLog=log;
    }

    @Override
    public void log() {
        nLog.d(1,"非常厉害的log");
    }
}
