package com.hjj.algorithm.easy;

import java.util.Stack;

/**
 * 创建时间：2022/9/17
 * 作者：
 * 功能描述：有效的括号算法
 */
public class ValidParentheses {
    private static boolean solution2(String s) {

        Stack<Character> stack=new Stack<>();

        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if(c=='['||c=='('||c=='{'){
                stack.push(c);
            }else{
                if(stack.size()==0){
                    return false;
                }
                switch (c){
                    case ']':{
                        Character pop = stack.pop();
                        if(pop!='['){
                            return false;
                        }
                        break;
                    }
                    case '}':{
                        Character pop = stack.pop();
                        if(pop!='{'){
                            return false;
                        }
                        break;
                    }
                    case ')':{
                        Character pop = stack.pop();
                        if(pop!='('){
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
