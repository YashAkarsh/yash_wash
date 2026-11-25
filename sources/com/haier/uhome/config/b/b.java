package com.haier.uhome.config.b;

import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class b extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uSDKError f28457a;

    public b(uSDKError usdkerror) {
        this.f28457a = usdkerror;
    }

    public uSDKError a() {
        return this.f28457a;
    }
}
