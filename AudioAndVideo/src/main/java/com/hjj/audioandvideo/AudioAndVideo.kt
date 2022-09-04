package com.hjj.audioandvideo

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Bundle
import com.hjj.lib_common.base.BaseActivity

class AudioAndVideo : BaseActivity() {
    private var mAudioTrack:AudioTrack?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAudioTrack = AudioTrack(
            AudioAttributes.Builder().setLegacyStreamType(3).build(),
            AudioFormat.Builder().setChannelMask(AudioFormat.CHANNEL_IN_MONO)
                .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                .setSampleRate(8000)
                .build(),
            AudioTrack.getMinBufferSize(8000, AudioFormat.CHANNEL_IN_MONO,
                AudioFormat.ENCODING_PCM_16BIT
            ),
            AudioTrack.MODE_STREAM,
            AudioManager.AUDIO_SESSION_ID_GENERATE
        )


    }

    private fun play(){
        if (mAudioTrack?.state != AudioTrack.STATE_UNINITIALIZED && mAudioTrack?.playState != AudioTrack.PLAYSTATE_PLAYING)
            mAudioTrack?.play()

    }
}