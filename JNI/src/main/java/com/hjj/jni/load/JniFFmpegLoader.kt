package com.hjj.jni.load

import android.view.Surface

object JniFFmpegLoader {
    external fun getFFmpegVersion(): String

    external fun setSurfaceNative(surface:Surface)

    external fun prepareNative(mDataSource:String)

    external fun startNative()

    external fun restartNative()

    external fun stopNative()

    external fun releaseNative()

    external fun isPlayerNative()

    init {
//        System.loadLibrary("YK_PLAYER")
    }
}