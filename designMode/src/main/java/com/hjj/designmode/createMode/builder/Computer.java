package com.hjj.designmode.createMode.builder;


import android.app.Application;

/**
 * 描述：
 * 在Computer 中创建一个静态内部类 Builder，然后将Computer 中的参数都复制到Builder类中。
 * 在Computer中创建一个private的构造函数，参数为Builder类型
 * 在Builder中创建一个public的构造函数，参数为Computer中必填的那些参数，cpu 和ram。
 * 在Builder中创建设置函数，对Computer中那些可选参数进行赋值，返回值为Builder类型的实例
 * 在Builder中创建一个build()方法，在其中构建Computer的实例并返回
 */
public class Computer {
    private String mCpu;
    private String mMemory;
    private String mHD;//
    private int usbCount;
    private String keyBoard;
    private String display;


    private Computer(Builder builder){

    }

    public static class Builder{
        private String mCpu;
        private String mMemory;
        private String mHD;//
        private int usbCount;
        private String keyBoard;
        private String display;

        public Builder(String cpu,String memory){
            this.mCpu=cpu;
            this.mMemory=memory;
        }

        public Builder setHD(String hd){
            this.mHD=hd;
            return this;
        }

        public Builder setUsbCount(int count){
            this.usbCount=count;
            return this;
        }

        public Builder setKeyBoard(String keyBoard){
            this.keyBoard=keyBoard;
            return this;
        }

        public Builder setDisplay(String display){
            this.display=display;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

}
