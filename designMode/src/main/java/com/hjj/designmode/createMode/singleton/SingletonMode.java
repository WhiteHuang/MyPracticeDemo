package com.hjj.designmode.createMode.singleton;

/**
 * 单例模式
 *
 */
public class SingletonMode {
    //饿汉式 start
    //写法简单，线程安全
    //没有懒加载效果，类记载时就会将类初始化
    private SingletonMode(){}

    /**
     * 此处跟随类的初始化，而一同初始化。累的初始化时线程安全的，所以此处也是线程安全的
     */
    private static final SingletonMode single=new SingletonMode();

    public static SingletonMode getInstance(){
        return single;
    }
    //饿汉式 end

    //懒汉式 start
    //使用懒加载效果，线程安全的
    //使用同步锁，增加了方法的消耗

    private static  SingletonMode singleLazy=null;

    public static synchronized SingletonMode getInstanceLazy(){
        if(singleLazy==null){
            singleLazy=new SingletonMode();
        }
        return single;
    }

    //懒汉式 end

    //双重检查模式 start

    private volatile static SingletonMode doubleSingleton;

    public static SingletonMode getInstanceDouble(){
        if(doubleSingleton==null){
            synchronized (SingletonMode.class){
                if(doubleSingleton==null){
                    doubleSingleton=new SingletonMode();
                }
            }
        }
        return doubleSingleton;
    }
    //双重检查模式 end

    //静态内部类 start

    private static SingletonMode getInstanceStatic(){
        return SingletonHolder.mode;
    }

    private static class SingletonHolder{
        private static final SingletonMode mode=new SingletonMode();
    }
    //静态内部类 end


}
