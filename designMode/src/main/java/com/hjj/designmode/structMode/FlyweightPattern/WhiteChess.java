package com.hjj.designmode.structMode.FlyweightPattern;

import android.graphics.Color;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class WhiteChess implements Chess {
    //内部状态，共享
    private final int color = Color.WHITE;

    private final String sharp = "圆形";

    public int getColor() {
        return color;
    }
    @Override
    public void draw(int x, int y) {
        System.out.println(String.format("%s白色棋子置于（%d，%d）处", sharp, x, y));
    }
}
