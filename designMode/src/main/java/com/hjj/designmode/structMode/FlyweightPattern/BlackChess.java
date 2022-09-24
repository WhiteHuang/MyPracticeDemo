package com.hjj.designmode.structMode.FlyweightPattern;

import android.graphics.Color;
import android.util.Log;

import com.hjj.designmode.structMode.proxyMode.IntermediaryProxy;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class BlackChess implements Chess {
    //内部状态，共享
    private final int color = Color.BLACK;

    private final String sharp = "圆形";

    public int getColor() {
        return color;
    }
    @Override
    public void draw(int x, int y) {
        System.out.println(String.format("%s黑色棋子置于（%d，%d）处", sharp, x, y));
    }
}
