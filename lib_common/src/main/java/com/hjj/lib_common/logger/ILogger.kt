package com.hjj.lib_common.logger

/**
 *创建时间：2022/9/24
 *作者：
 *功能描述：
 */
interface ILogger {
    fun e(tag: String, msg: String)
    fun w(tag: String, msg: String)
    fun i(tag: String, msg: String)
    fun d(tag: String, msg: String)
}