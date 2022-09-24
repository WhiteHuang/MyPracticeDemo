package com.hjj.lib_common.logger

import android.util.Log

/**
 *创建时间：2022/9/24
 *作者：
 *功能描述：Log工具类
 * 默认[LogUtil.logger]为null时自动使用android系统log。
 * 第三方Logger可以通过添加一个装饰器进行封装通过[LogUtil.setLogger]方法注入
 */
object LogUtil : ILogger {
    /**
     * Priority constant for the println method; use Log.v.
     */
    val VERBOSE = 2

    /**
     * Priority constant for the println method; use Log.d.
     */
    val DEBUG = 3

    /**
     * Priority constant for the println method; use Log.i.
     */
    val INFO = 4

    /**
     * Priority constant for the println method; use Log.w.
     */
    val WARN = 5

    /**
     * Priority constant for the println method; use Log.e.
     */
    val ERROR = 6

    private var curLevel = VERBOSE

    private var logger: ILogger? = null

    public fun setLogger(logger: ILogger) {
        this.logger = logger
    }

    override fun e(tag: String, msg: String) {
        if (getCurLevelShow(ERROR)) {
            logger?.e(tag, msg) ?:run{
                Log.e(tag, msg)
            }
        }
    }

    override fun w(tag: String, msg: String) {
        if (getCurLevelShow(WARN)) {
            logger?.w(tag, msg) ?:run{
               Log.w(tag, msg)
            }
        }
    }

    override fun i(tag: String, msg: String) {
        if (getCurLevelShow(INFO)) {
            logger?.i(tag, msg) ?:run{
                Log.i(tag, msg)
            }
        }
    }

    override fun d(tag: String, msg: String) {
        if (getCurLevelShow(DEBUG)) {
            logger?.d(tag, msg) ?:run{
                Log.d(tag, msg)
            }
        }
    }

    /**
     * 获取当前等级是否显示
     */
    private fun getCurLevelShow(level: Int): Boolean {
        return curLevel == level || curLevel == VERBOSE
    }

}