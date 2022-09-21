package com.hjj.algorithm.easy;

import java.util.HashMap;
/**
 * 创建时间：2022/9/17
 * 作者：
 * 功能描述：罗马数字转为数字
 */
public class RomanNumeralsToIntegers {

    private static int solution(String s){
        HashMap<Character,Integer> map=new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int l = s.length();
        int number = 0;
        int integer = map.get(s.charAt(0));
        for (int i = 1; i < l; i++) {
            char c = s.charAt(i);
            int integerRight = map.get(c);
            if (integer < integerRight) {
                number -=integer;
            }else{
                number += integer;
            }
            integer=integerRight;
        }
        number += integer;
        return number;
    }
}
