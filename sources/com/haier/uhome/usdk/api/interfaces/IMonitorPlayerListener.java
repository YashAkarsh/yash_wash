package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.usdk.api.MonitorPlayerStatus;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public interface IMonitorPlayerListener {
    void onPlayFileFinished(long j7);

    void onPlayerStatusUpdate(MonitorPlayerStatus monitorPlayerStatus);

    void onReceiveError(uSDKError usdkerror);

    void onTime(long j7);

    void updateSpeed(int i7);
}
