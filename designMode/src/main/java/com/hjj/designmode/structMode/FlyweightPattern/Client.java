package com.hjj.designmode.structMode.FlyweightPattern;


import android.graphics.Color;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：享元模式 复用对象，实例：java 的常量池（比如 String），线程池，Message.obtain 等
 */
public class Client {
    public static void main(String[] args) {
        playChess();
    }

    public static void playChess() {
        //下黑子
        Chess backChess1 = ChessFactory.getChess(Color.BLACK);
        backChess1.draw(2, 5);

        //下白子
        Chess whiteChess = ChessFactory.getChess(Color.WHITE);
        whiteChess.draw(3, 5);

        //下黑子
        Chess backChess2 = ChessFactory.getChess(Color.BLACK);
        backChess2.draw(2, 6);

        System.out.println(String.format("backChess1:%d | backChess2:%d | whiteChess:%d",
                backChess1.hashCode(), backChess2.hashCode(), whiteChess.hashCode()));
    }
}
