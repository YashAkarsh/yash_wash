package com.haier.uhome.video.api;

import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public interface MonitorPlaybackListener<T> {
    void onError(uSDKError usdkerror);

    void onStart();

    void onSuccess(T t7);
}
