package com.hjj.lib_common.util

class ThreadLocalDemo {
    fun test(){
        val thl=object:ThreadLocal<Int>(){
            override fun initialValue(): Int? {
                return super.initialValue()
            }
        }
    }
}