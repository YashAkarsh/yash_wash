package com.haier.uhome.usdk.base.b;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class a extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uSDKError f31234a;

    public a(int i7) {
        this.f31234a = com.haier.uhome.usdk.base.utils.c.a(i7);
    }

    public uSDKError a() {
        return this.f31234a;
    }

    public a(ErrorConst errorConst) {
        super(errorConst.getErrorInfo());
        this.f31234a = errorConst.toError();
    }

    public a(uSDKError usdkerror) {
        super(usdkerror.getDescription());
        this.f31234a = usdkerror;
    }
}
