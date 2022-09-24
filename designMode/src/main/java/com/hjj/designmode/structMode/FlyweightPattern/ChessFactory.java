package com.hjj.designmode.structMode.FlyweightPattern;

import android.graphics.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建时间：2022/9/21
 * 作者：
 * 功能描述：
 */
public class ChessFactory {
    private static final Map<Integer, Chess> chessMap = new HashMap<>();

    public static Chess getChess(Integer color) {
        Chess chess = chessMap.get(color);
        if (chess == null) {
            chess = color == Color.WHITE ? new WhiteChess() : new BlackChess();
            chessMap.put(color, chess);
        }
        return chess;
    }
}
