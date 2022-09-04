//
// Created by 黄嘉嘉 on 2022/7/9.
//

#ifndef MYPRACTICEDEMO_OPENSLAUDIOPLAY_H
#define MYPRACTICEDEMO_OPENSLAUDIOPLAY_H

#include "AudioEngine.h"


class OpenSLAudioPlay {
private:
    AudioEngine *mAudioEngine;
    SLObjectItf mPlayerObj;
    SLPlayItf mPlayer;
    SLAndroidSimpleBufferQueueItf mBufferQueue;
    SLEffectSendItf mEffectSend;
    SLVolumeItf mVolume;
    SLmilliHertz mSampleRate;
    int mSampleFormat;
    int mChannels;

    uint8_t *mBuffers[2];
    SLuint32 mBufSize;
    int mIndex;
    pthread_mutex_t mMutex;

public:
    OpenSLAudioPlay(int sampleRate, int sampleFormat, int channels);

    bool init();

    void enqueueSample(void *data, size_t length);

    void release();

    ~OpenSLAudioPlay();

    friend void playerCallback(SLAndroidSimpleBufferQueueItf bq, void *context);
};



#endif //MYPRACTICEDEMO_OPENSLAUDIOPLAY_H
