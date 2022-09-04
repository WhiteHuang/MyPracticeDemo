package com.hjj.jni.load

import com.hjj.jni.data.TestData
import java.lang.NullPointerException

object JniLoader {


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    /**
     * 静态注册
     */
    external fun test(
        b: Boolean,
        b1: Byte,
        c: Char,
        s: Short,
        l: Long,
        f: Float,
        d: Double,
        name: String,
        age: Int,
        i: IntArray,
        strs: Array<String>,
        person: TestData,
        bArray: BooleanArray
    )

    /**
     * 静态注册
     */
    external fun getTestData():TestData

    /**
     * 动态注册
     */
    external fun dynamicRegister(name:String)

    /**
     * 动态注册
     */
    external fun dynamicRegister2(name:String)

    @Throws(NullPointerException::class)
    fun testException(){
        throw NullPointerException("test nullException")
    }

    // Used to load the 'native-lib' library on application startup.
    init {
        System.loadLibrary("native-lib")
    }

}