package com.haier.uhome.usdk.b;

import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.uSDKErrorConst;

/* JADX INFO: loaded from: classes2.dex */
class d implements IuSDKCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IuSDKCallback f31084a;

    d(IuSDKCallback iuSDKCallback) {
        this.f31084a = iuSDKCallback;
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
    public void onCallback(uSDKErrorConst usdkerrorconst) {
        IuSDKCallback iuSDKCallback = this.f31084a;
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(usdkerrorconst);
        }
    }
}
