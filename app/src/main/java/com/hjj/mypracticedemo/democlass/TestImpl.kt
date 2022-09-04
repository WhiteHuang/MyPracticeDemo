package com.hjj.mypracticedemo.democlass

class TestImpl : Test1, TestAb1() {



    override var jl: Int
        get() = 0
        set(value) {}


    override fun test() {
        test1()
        Test1.test2()
    }

    override fun testAb() {

    }

}