package com.hjj.designmode.createMode.singleton

class KtSingletonMode private constructor() {
    companion object {
        val instane = KtSingletonMode()
    }
}