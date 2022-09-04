package com.hjj.lib_common.util

import java.io.InputStream
import java.io.OutputStream
import java.io.Reader
import java.io.Writer
import java.lang.reflect.InvocationHandler

object ReflectionClassUtil {

    fun getStringClass(classPath: String) {
        val classD = Class.forName(classPath)//获取Class
        val fatherClass = classD.superclass//获取父类class
        getField(classD)

    }

    /**
     * 获取class属性Field
     * field包含了一个字段的
     * getName()：返回字段名称，例如，"name"；
     *getType()：返回字段类型，也是一个Class实例，例如，String.class；
     *getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
     */
    private fun getField(classD: Class<*>) {
        //field包含了一个字段的
//        getName()：返回字段名称，例如，"name"；
//getType()：返回字段类型，也是一个Class实例，例如，String.class；
//getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。

        val fieldPublic = classD.getField("")//根据名字获取当前类的某个public的Field
        val fieldPrivate = classD.getDeclaredField("")//根据名字获取当前类的某个private的Field
        val fieldsPublic = classD.fields//获取当前类的public的Field
        val fieldsPrivate = classD.declaredFields//获取当前类的private的Field

        fieldPublic.get("obj")//获取Field设置obj实例的值
        fieldPublic.set("obj", "value")//将Field的obj实例的值 改为value
    }

    /**
     * 获取class的Method
     * 一个Method对象包含一个方法的所有信息：
     * getName()：返回方法名称，例如："methodName"；
     *  getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
     * getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
     * getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义。
     * 通过[java.lang.reflect.Method.invoke]执行当前方法
     */
    private fun getMethod(classD: Class<*>) {
        val method = classD.getMethod(
            "methodName",
            Int::class.java,
            String::class.java
        )//根据名字和参数获取当前类的某个public的method
        classD.getDeclaredMethod("methodName", Int::class.java)//根据名字和参数获取当前类的某个private的method
        classD.methods//获取当前类的public的method
        classD.declaredMethods//获取当前类的private的method
    }

    /**
     * 获取class的构造方法
     *Class getSuperclass()：获取父类类型；
     *Class[] getInterfaces()：获取当前类实现的所有接口。
     */
    private fun getConstructor(classD: Class<*>) {
        val constructor = classD.getConstructor(Int.javaClass, String.javaClass)
        val newInstance = constructor.newInstance(1, "")
        classD.interfaces//获取实现的接口

        Int.javaClass.isAssignableFrom(classD)//判断classD是否可以赋值给Int，类似于kotlin的is关键字
    }

    /**
     * 动态代理
     * 在运行期动态创建一个interface实例的方法如下：

     *定义一个InvocationHandler实例，它负责实现接口的方法调用；
     *通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
     *使用的ClassLoader，通常就是接口类的ClassLoader；
     *需要实现的接口数组，至少需要传入一个接口进去；
     *用来处理接口方法调用的InvocationHandler实例。
     *将返回的Object强制转型为接口。
     */
    private fun invactaionHandler(classD: Class<*>){
        val invocationHandler= InvocationHandler { proxy, method, args ->
            System.out.println(method)
            if(method.name.equals("指定方法名")){
                //TODO 执行方法
                val any = args[0] //获取参数
            }
            Any()
        }

//        val hello: Hello = Proxy.newProxyInstance(
//            Hello::class.java.getClassLoader(), arrayOf<Class<*>>(Hello::class.java),  // 传入要实现的接口
//            handler
//        ) as Hello // 传入处理调用方法的InvocationHandler
//
//        hello.morning("Bob")

    }
}