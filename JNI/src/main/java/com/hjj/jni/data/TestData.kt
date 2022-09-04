package com.hjj.jni.data

data class TestData(
    var name: String = "沈怡",
    var age: Int = 18
){
    override fun toString(): String {
        return "TestData name=$name ,age = $age"
    }
}