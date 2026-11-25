package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum MonitorPlayerStatus {
    STATE_IDLE(com.haier.uhome.video.i.STATE_IDLE),
    STATE_INITIALIZED(com.haier.uhome.video.i.STATE_INITIALIZED),
    STATE_PREPARING(com.haier.uhome.video.i.STATE_PREPARING),
    STATE_READY(com.haier.uhome.video.i.STATE_READY),
    STATE_LOADING(com.haier.uhome.video.i.STATE_LOADING),
    STATE_PLAY(com.haier.uhome.video.i.STATE_PLAY),
    STATE_PAUSE(com.haier.uhome.video.i.STATE_PAUSE),
    STATE_STOP(com.haier.uhome.video.i.STATE_STOP),
    STATE_SEEKING(com.haier.uhome.video.i.STATE_SEEKING);

    private com.haier.uhome.video.i playerStatus;

    MonitorPlayerStatus(com.haier.uhome.video.i iVar) {
        this.playerStatus = iVar;
    }

    public static MonitorPlayerStatus getPlayerStatus(String str) {
        return valueOf(str);
    }
}
