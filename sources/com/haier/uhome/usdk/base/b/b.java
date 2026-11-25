package com.haier.uhome.usdk.base.b;

import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uSDKError f31235a;

    public b(uSDKError usdkerror) {
        super(usdkerror == null ? "" : usdkerror.toString());
        this.f31235a = usdkerror;
    }

    public uSDKError a() {
        return this.f31235a;
    }
}
