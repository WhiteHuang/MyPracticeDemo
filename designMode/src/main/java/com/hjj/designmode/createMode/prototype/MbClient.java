package com.hjj.designmode.createMode.prototype;

/**
 * 创建时间：2022/9/20
 * 作者：
 * 功能描述：
 */
public class MbClient {
    public static void main(String[] args) {
        Message message=new Message("Tom","吃饭",25d);
        Message msg1=message.clone();
        Message msg2=message.clone();
        msg1.setMessage("Kim","游戏",500);
        msg2.setMessage("King","旅游",1000);
    }
}
