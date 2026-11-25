package com.haier.uhome.control.local.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public enum UpdateProgress {
    UPDATE_PROGRESS_CONNECTING("连接中"),
    UPDATE_PROGRESS_UPDATING("更新中");


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29302c;

    UpdateProgress(String str) {
        this.f29302c = str;
    }

    @Keep
    public String getStateDescription() {
        return this.f29302c;
    }
}
